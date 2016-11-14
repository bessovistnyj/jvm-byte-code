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
    public void whenAllcorrectThenReturnString() throws IOException{
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));

        ByteArrayInputStream in = new ByteArrayInputStream("проверка Лишних слов на ВЫЛЕТ".getBytes());
        String[] abuse = new String[]{"На","ВЫЛЕТ","Лишних"};

        AbuseWord abuseWord = new AbuseWord();

        abuseWord.dropAbuses(in, result, abuse);
        assertThat(result.toString(),is("проверка  слов  "));
    }

}
