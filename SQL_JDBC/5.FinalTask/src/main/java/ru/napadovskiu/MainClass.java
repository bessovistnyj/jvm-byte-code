package ru.napadovskiu;

import ru.napadovskiu.parsingHTML.ParsingHTML;
import ru.napadovskiu.settings.Settings;
import java.io.InputStream;
import java.util.Timer;

public class MainClass {


    public static void main (String[] args) {
        ClassLoader loader = Settings.class.getClassLoader();
        InputStream io = loader.getResourceAsStream("app.properties");
        Settings settings = new Settings();
        settings.load(io);
        int count = Integer.parseInt(settings.getValue("countLaunch"));

        Timer timer = new Timer();
        ParsingHTML parsingHTML = new ParsingHTML();
       // parsingHTML.run();

        timer.scheduleAtFixedRate(parsingHTML,0, 60 * 60 * 24 * 1000 / 5);


    }

}
