package ru.napadovskiu.parsingHTML;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class ParsingHTML {

    public void parseHTML() {
      //  Document doc = null;
     //   Elements topics = null;
        String currentPage = String.format("%s/%d", "http://www.sql.ru/forum/job-offers", 1);

        try {
            Document doc = Jsoup.connect(currentPage).get();
            Elements topics = doc.select("tr:has(.postslisttopic)");
            for (Element topic : topics) {
                if (topic.text().toLowerCase().contains("java") && !topic.text().toLowerCase().contains("script")) {
                    Elements link = topic.select("td.postslisttopic > a[href]");
                    Elements data = topic.select("td");
                    String linkVacancy = link.attr("href");
                    String description = link.get(0).text();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
