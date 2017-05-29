package ru.napadovskiuB;

import java.util.Random;

/**
 * Created by napadovskiuB on 25.05.2017.
 */
public class CreateRandomString  {

    /**
     *
     * @param length string length.
     * @return result creating string.
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
