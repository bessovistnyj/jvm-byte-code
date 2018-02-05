package ru.napadovskiu.parsingHTML;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.napadovskiu.Vacancy;
import ru.napadovskiu.paseDate.ParseDate;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;


public class ParsingHTML {

    public void parseHTML() {
      //  Document doc = null;
     //   Elements topics = null;
        ParseDate parseDate = new ParseDate();
        String currentPage = String.format("%s/%d", "http://www.sql.ru/forum/job-offers", 1);

        try {
            Document doc = Jsoup.connect(currentPage).get();
            Elements topics = doc.select("tr:has(.postslisttopic)");
            for (Element topic : topics) {
                if (topic.text().toLowerCase().contains("java") && !topic.text().toLowerCase().contains("script")) {
                    Elements link = topic.select("td.postslisttopic > a[href]");
                    Elements data = topic.select("td");
                    String author = topic.select("td.altCol > a[href]").get(0).text();
                    String linkVacancy = link.attr("href");
                    String description = link.get(0).text();
                    String dateForParse = topic.select("td.altCol").get(1).childNode(0).toString();
                    parseDate.getDateFromString(dateForParse);

                    int a=1;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
