package ru.napadovskiuB;

import java.util.Random;

/**
<<<<<<< HEAD
 * Created by Napadovskiy on 25.05.2017.
=======
 * Created by napadovskiuB on 25.05.2017.
>>>>>>> 48a903de654ac10c8f32e95fc512153901c311fb
 */
public class CreateRandomString  {

    /**
<<<<<<< HEAD
     * Method create random string.
     * @param length length string.
     * @return result string.
=======
     *
     * @param length string length.
     * @return result creating string.
>>>>>>> 48a903de654ac10c8f32e95fc512153901c311fb
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
