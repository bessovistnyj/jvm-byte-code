package ru.napadovskiu;

import ru.napadovskiu.parsingHTML.ParsingHTML;

public class MainClass {



    public static void main (String[] args) {
        ParsingHTML parsingHTML = new ParsingHTML();
        parsingHTML.parseHTML();
        //Init init = new Init();
//        final ParsingHTML parser = new ParsingHTML();
//        final long periodicity = 1000 * 60 * 60 * 24 * init.getPeriodicity();

//        new Thread(new Runnable() {
//            public void run() {
//                while (true) {
//                    try {
//                        parser.parseHTML();
//                        Thread.sleep(periodicity);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();

    }

}
