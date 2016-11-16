package ru.napadovskiu;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;


import java.util.*;
/**
 * Created by program on 01.11.2016.
 */

public class AbuseWordTest {

    @Test
    public void whenAllCorrectThenReturnString() throws IOException{
        String result = null;

        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream("test abuse words with OUT ".getBytes());
        ){
            System.setOut(new PrintStream(outputStream));

            String[] abuse = new String[]{"test","Abuse"};

            AbuseWord abuseWord = new AbuseWord();

            abuseWord.dropAbuses(in, outputStream, abuse);
            result = outputStream.toString();
        }
        catch (IOException error){
            error.printStackTrace();
        }


        assertThat(result,is("  words with OUT "));
    }

}
