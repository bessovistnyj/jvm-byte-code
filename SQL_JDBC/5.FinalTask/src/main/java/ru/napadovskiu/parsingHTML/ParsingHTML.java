package ru.napadovskiu.parsingHTML;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.napadovskiu.sql.ConnectDB;
import ru.napadovskiu.vacancy.Vacancy;
import ru.napadovskiu.parseDate.ParseDate;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.TimerTask;


public class ParsingHTML  extends TimerTask {

    private final ParseDate parseDate = new ParseDate();

    private final ConnectDB dbConnection = new ConnectDB();

    private Vacancy parseLink(Element topic) throws ParseException {

        Vacancy vac =null;
        if (topic.text().toLowerCase().contains("java") && !topic.text().toLowerCase().contains("script")) {
            Elements link = topic.select("td.postslisttopic > a[href]");
            String author = topic.select("td.altCol > a[href]").get(0).text();
            String linkVacancy = link.attr("href");
            String description = link.get(0).text();
            String dateForParse = topic.select("td.altCol").get(1).childNode(0).toString();
            Timestamp vacDate = this.parseDate.getDateFromString(dateForParse);
            vac = new Vacancy(vacDate, linkVacancy, author, description);

        }
       return vac;
    }



    public void parseHTML() {
        int numberPage =1;

        boolean stopParse =false;

        this.dbConnection.createDateBase();

        Timestamp dateForCheck = null;

        if (this.dbConnection.itIsFirstLaunch()) {
            dateForCheck = this.parseDate.getDateToBeginningYear();
        } else {
            dateForCheck = this.dbConnection.getDateLastVacancy();
        }
        while (!stopParse) {
            String currentPage = String.format("%s/%d", "http://www.sql.ru/forum/job-offers", numberPage);
            try {
                Document doc = Jsoup.connect(currentPage).get();
                Elements topics = doc.select("tr:has(.postslisttopic)");
                for (Element topic : topics) {
                    Vacancy vacancy = parseLink(topic);
                    if (vacancy != null || vacancy.getVac_Date().before(dateForCheck)) {
                        if (!this.dbConnection.vacancyExist(vacancy)) {
                            this.dbConnection.addVacancy(vacancy);
                        }
                    }
                    if (!vacancy.getVac_Date().before(dateForCheck)) {
                        stopParse = true;
                    }
                }
            } catch (IOException | ParseException e) {
                stopParse = true;
                numberPage++;
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        parseHTML();
    }
}
