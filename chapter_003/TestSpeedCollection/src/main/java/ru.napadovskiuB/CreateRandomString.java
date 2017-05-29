package ru.napadovskiuB;

import java.util.Random;

/**
 * Created by Программист on 25.05.2017.
 */
public class CreateRandomString  {

    /**
     *
     * @param length
     * @return
     */
    public String createRandomString(int length) {
        final String valid = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        Random rn = new Random();
        String line = "";
        while (length-- > 0) {
            line += valid.charAt(rn.nextInt(valid.length()));
        }
         return line;
    }
}
