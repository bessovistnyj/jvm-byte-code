package ru.napadovskiuB;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Программист on 18.07.2017.
 */
public class SimpleMapTest {

    @Test
    public void whenInsert() {
        SimpleMap<Integer,String> myMap = new SimpleMap<>();

        myMap.insert(5,"Пятый");
        myMap.insert(4,"Четвертый");
        myMap.insert(6,"Шестой");
        myMap.insert(3,"Третий");
        myMap.insert(1,"Первый");
        int a =1;

    }

}