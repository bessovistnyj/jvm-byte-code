package ru.napadovskiu;

import java.io.IOException;
import java.io.InputStream;
/**
 * Created by program on 01.11.2016.
 */
public class EvenNumber {


    public boolean checkEvenNumber(InputStream inputStream) throws IOException{
        boolean result = false;
        if (inputStream.read() % 2 == 0) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

}
