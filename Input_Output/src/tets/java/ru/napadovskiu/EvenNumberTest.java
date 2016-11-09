package ru.napadovskiu;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;


import java.util.*;
/**
 * Created by program on 01.11.2016.
 */
@Ignore
public class EvenNumberTest {

    @Test
    public void whenInputEvenNumberThenReturnTrue(){
        boolean result = false;
        EvenNumber evenNumber = new EvenNumber();

        try (InputStream inputStream = new ByteArrayInputStream("4".getBytes())){

            result = evenNumber.checkEvenNumber(inputStream);

        }
        catch (IOException error){
            error.printStackTrace();
        }
        assertThat(result, is(true));
    }

    @Test
    public void whenInputOddNumberThenReturnFalse() {

        boolean result = false;
        EvenNumber evenNumber = new EvenNumber();

        try (InputStream inputStream = new ByteArrayInputStream("3".getBytes())){

            result = evenNumber.checkEvenNumber(inputStream);

        }
        catch (IOException error){
            error.printStackTrace();
        }
        assertThat(result, is(true));
    }

 }
