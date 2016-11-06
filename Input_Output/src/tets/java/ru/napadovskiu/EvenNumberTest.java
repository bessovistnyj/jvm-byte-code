package ru.napadovskiu;

import static org.hamcrest.core.Is.is;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.Test;


import java.util.*;
/**
 * Created by program on 01.11.2016.
 */
public class EvenNumberTest {

    @Test
    public void whenInputEvenNumberThenReturnTrue() throws Exception{
        InputStream inputStream = new ByteArrayInputStream("4".getBytes());

        EvenNumber evenNumber = new EvenNumber();

        boolean result = evenNumber.checkEvenNumber(inputStream);

        assertThat(result, is(true));
    }

    @Test
    public void whenInputOddNumberThenReturnFalse() throws  Exception{
        InputStream inputStream = new ByteArrayInputStream("5".getBytes());

        EvenNumber evenNumber = new EvenNumber();

        boolean result = evenNumber.checkEvenNumber(inputStream);

        assertThat(result, is(true));
    }

 }
