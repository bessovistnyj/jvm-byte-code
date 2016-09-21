package ru.napadovskiu.tracker;

import static org.hamcrest.core.Is.is;

import  ru.napadovskiu.items.*;

import org.junit.Test;
import ru.napadovskiu.items.*;

import static org.junit.Assert.*;

public class StartUITest {
    private Tracker     tracker;
    private Item        tmpItem;
    private Input       input;
    private StartUI     userAction;


    private void init(String[] params){
        Input input = new StubInput(params);
        this.userAction = new StartUI(input,new Tracker());
        userAction.init();
    }


    @Test
    public void whenAddNewItem()  {
        String[] params = new String[] {"1","namefirstItem","descfirstItem","7"};
        this.init(params);
        assertThat(this.userAction.getTracker().showAllItem().length, is(1));
    }

    @Test
    public void whenFindItemByNameDescription()  {
        //Item tmpItem = new Item("namefirstItem","descfirstItem");
        String[] params = new String[] {"1",tmpItem.getName(),tmpItem.getDescription(),"3",tmpItem.getName(),tmpItem.getName(),"7"};
        Input input = new StubInput(params);
        this.init(params);
        assertThat(this.userAction.getTracker().findItem(tmpItem.getName(),tmpItem.getDescription())[0].getName(), is(tmpItem.getName()));
    }

//    @Test
//    public void whenFindById()  {
//        tmpItem = new Item("namefirstItem","descfirstItem");
//        tracker = this.userAction.getTracker().findItem(tmpItem.getName(),tmpItem.getDescription())[0].getId();
//        String[] params = new String[] {"1","namefirstItem","descfirstItem","4",tracker().findItem(tmpItem.getName(),tmpItem.getDescription())[0].getId(),"7"};
//        Input input = new StubInput(params);
//        this.init(params);

//        assertThat(this.userAction.getTracker().findItem(tmpItem.getName(),tmpItem.getDescription())[0].getId(), is(tmpItem.getId()));
//    }

//    @Test
//    public void whenEditItem()  {
//        String[] params = new String[] {"1","namefirstItem","descfirstItem","2","7"};
//        Input input = new StubInput(params);
//        this.init(params);
//        assertThat(this.userAction.getTracker().showAllItem().length, is(1));
//    }
//    @Test
//    public void whenDeleteItem()  {
//        String[] params = new String[] {"1","namefirstItem","descfirstItem","2","7"};
//        Input input = new StubInput(params);
//        this.init(params);
//        assertThat(this.userAction.getTracker().showAllItem().length, is(1));
//    }
//    @Test
//    public void whenShowAllItem()  {
//        String[] params = new String[] {"1","namefirstItem","descfirstItem","2","7"};
//        Input input = new StubInput(params);
//        this.init(params);
//        assertThat(this.userAction.getTracker().showAllItem().length, is(1));
//    }

}