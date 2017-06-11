package ru.napadovskiu.tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import  ru.napadovskiu.items.Item;

import org.junit.Test;

/**
 *
 */
public class StartUITest {
    /**
     *
      */
    private StartUI userAction;

    /**
     *
     */
    private Tracker tracker = new Tracker();

    /**
     *
     * @param params
     */
    private void init(String[] params) {
        Input input = new StubInput(params);
        this.userAction = new StartUI(input, this.tracker);
        userAction.init();
    }

    /**
     *
     */
    @Test
    public void whenAddNewItemThenTrackerAddItem() {
        Item tmpItem = new Item("namefirstItem", "descfirstItem");
        String[] params = new String[] {"1", tmpItem.getName(), tmpItem.getDescription(), "8"};
        this.init(params);
        assertThat(this.tracker.findItemByName("namefirstItem")[0].getName(), is(tmpItem.getName()));
   }

    /**
     *
     */
   @Test
    public void whenFindItemByName() {
        String[] firstParams = new String[] {"1", "namefirstItem", "descfirstItem", "1", "namefirstItem1", "descfirstItem1", "1", "namesecondItem", "DescsecondItem", "8"};
        this.init(firstParams);
        String[] secondParams = new String[] {"3", "namefirstItem", "8"};
        this.init(secondParams);
        assertThat(this.tracker.findItemByName("namefirstItem")[0].getName(), is("namefirstItem"));
    }

    /**
     *
     */
    @Test
    public void whenFindById() {
        String[] firstParams = new String[] {"1", "namefirstItem", "descfirstItem", "1", "nameSecondItem", "descSecondItem", "8"};
        this.init(firstParams);
        String[] secondParams = new String[] {"4", this.tracker.getAllItem()[0].getId(), "8"};
        this.init(secondParams);
        assertThat(this.tracker.findItemById(this.tracker.getAllItem()[0].getId()).getName(), is("namefirstItem"));

    }

    /**
     *
     */
    @Test
    public void whenEditItem() {
        String[] firstParams = new String[] {"1", "namefirstItem", "descfirstItem", "1", "nameSecondItem", "descSecondItem", "8"};
        this.init(firstParams);
        String[] secondParams = new String[] {"5", this.tracker.findItemByName("namefirstItem")[0].getId(), "nameEditItem", "descEditItem", "8"};
        this.init(secondParams);
        assertThat(this.tracker.findItemById(this.tracker.getAllItem()[0].getId()).getName(), is("nameEditItem"));
    }

    /**
     *
     */
    @Test
    public void whenDeleteItem() {
        String[] firstParams = new String[] {"1", "namefirstItem", "descfirstItem", "1", "nameSecondItem", "descSecondItem", "8"};
        this.init(firstParams);
        String[] secondParams = new String[] {"6", this.tracker.findItemByName("namefirstItem")[0].getId(), "8"};
        this.init(secondParams);

        assertNull(this.tracker.getAllItem()[0]);

    }

}
