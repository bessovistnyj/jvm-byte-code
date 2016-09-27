package ru.napadovskiu.tracker;

import static org.hamcrest.core.Is.is;

import  ru.napadovskiu.items.*;

import org.junit.Test;


import static org.junit.Assert.*;

public class StartUITest {
     private StartUI     userAction;
     private Tracker     tracker = new Tracker();

    private void init(String[] params){
        Input input = new StubInput(params);
        this.userAction = new StartUI(input,this.tracker);
        userAction.init();
    }

    @Test
    public void whenAddNewItemThenTrackerAddItem()  {
       String[] params = new String[] {"1","namefirstItem","descfirstItem","8"};
       this.init(params);
       assertThat(this.tracker.getAllItem().length, is(1));
   }

    @Test
    public void whenFindItemByNameDescription()  {
        String[] firstParams = new String[] {"1","namefirstItem","descfirstItem","1","namefirstItem1","descfirstItem1","1","namesecondItem","DescsecondItem","8"};
        this.init(firstParams);
        String[] secondParams = new String[] {"3","namefirstItem","Desc","8"};
        this.init(secondParams);
        assertThat(this.tracker.findItem("namefirstItem","Desc")[0].getName(), is("namefirstItem"));
    }

    @Test
    public void whenFindById()  {
        String[] firstParams = new String[] {"1","namefirstItem","descfirstItem","1","nameSecondItem","descSecondItem","8"};
        this.init(firstParams);
        String[] secondParams = new String[] {"4",this.tracker.getAllItem()[0].getId(),"8"};
        this.init(secondParams);
        assertThat(this.tracker.findItemById(this.tracker.getAllItem()[0].getId()).getName(), is("namefirstItem"));

    }

    @Test
    public void whenEditItem()  {
        String[] firstParams = new String[] {"1","namefirstItem","descfirstItem","1","nameSecondItem","descSecondItem","8"};
        this.init(firstParams);
        String[] secondParams = new String[] {"5",this.tracker.findItem("namefirstItem","descfirstItem")[0].getId(),"nameEditItem","descEditItem","8"};
        this.init(secondParams);
        assertThat(this.tracker.findItemById(this.tracker.getAllItem()[0].getId()).getName(), is("nameEditItem"));
    }

    @Test
    public void whenDeleteItem()  {
        String[] firstParams = new String[] {"1","namefirstItem","descfirstItem","1","nameSecondItem","descSecondItem","8"};
        this.init(firstParams);
        String[] secondParams = new String[] {"6",this.tracker.findItem("namefirstItem","descfirstItem")[0].getId(),"8"};
        this.init(secondParams);
        assertThat(this.tracker.getAllItem().length, is(1));
    }

}