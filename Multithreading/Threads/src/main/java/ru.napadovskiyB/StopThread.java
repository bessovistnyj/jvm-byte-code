package ru.napadovskiyB;

public class StopThread {

    public static void main(String[] args) {

        String checkString = "При проведении документа Приходная накладная почему-то проверяется остаток на складе.";
        Thread countChar = new Thread(new CountChar(checkString));
        Thread time = new Thread(new Time(10));

    }
 }
