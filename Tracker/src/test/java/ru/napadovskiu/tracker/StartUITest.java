package ru.napadovskiu.tracker;

import static org.hamcrest.core.Is.is;

import  ru.napadovskiu.items.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class StartUITest {
     private String[]  params;
     private Tracker   tracker =  new Tracker();
     private Input     input;


    @Test
    public void whenAddNewItem()  {
        this.params = new String[] {"1","namefirstItem","descfirstItem","7"};
        this.input = new StubInput(params);
        StartUI userAction = new StartUI(input,this.tracker);
        userAction.init();
        //assertThat(userAction.getTracker(), is(firstItem));
    }
//
//    @Test
//    public void init() throws Exception {
//
//    }
//
//    @Test
//    public void main() throws Exception {
//
//    }

}