package ru.napadovskiu.tracker;

import static org.hamcrest.core.Is.is;

import  ru.napadovskiu.items.*;

import org.junit.Test;
import ru.napadovskiu.items.*;

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
        String[] params = new String[] {"1","namefirstItem","descfirstItem","7"};
        this.init(params);
        assertThat(this.tracker.showAllItem().length, is(1));
    }

    @Test
    public void whenFindItemByNameDescription()  {
        String[] firstParams = new String[] {"1","namefirstItem","descfirstItem","1","nameSecondItem","descSecondItem","7"};
        this.init(firstParams);
        String[] secondParams = new String[] {"3",this.tracker.showAllItem()[0].getName(),this.tracker.showAllItem()[0].getDescription(),"7"};
        this.init(secondParams);
        assertThat(this.tracker.findItem("namefirstItem","descfirstItem")[0].getName(), is("namefirstItem"));
    }

    @Test
    public void whenFindById()  {
        String[] firstParams = new String[] {"1","namefirstItem","descfirstItem","1","nameSecondItem","descSecondItem","7"};
        this.init(firstParams);
        String[] secondParams = new String[] {"4",this.tracker.showAllItem()[0].getId(),"7"};
        this.init(secondParams);
        assertThat(this.tracker.findItem(this.tracker.showAllItem()[0].getId())[0].getName(), is("namefirstItem"));

    }

    @Test
    public void whenEditItem()  {
        String[] firstParams = new String[] {"1","namefirstItem","descfirstItem","1","nameSecondItem","descSecondItem","7"};
        this.init(firstParams);
        String[] secondParams = new String[] {"4",this.tracker.showAllItem()[0].getId(),"7"};
        this.init(secondParams);
        assertThat(this.tracker.findItem(this.tracker.showAllItem()[0].getId())[0].getName(), is("namefirstItem"));
    }
////    @Test
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