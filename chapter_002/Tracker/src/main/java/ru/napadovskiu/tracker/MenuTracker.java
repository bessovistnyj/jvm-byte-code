package ru.napadovskiu.tracker;

import ru.napadovskiu.items.Item;
import ru.napadovskiu.items.Comments;

import java.util.ArrayList;
import java.util.List;

/**
 *Class menu tracker.
 */
public class MenuTracker {
    /**
     * input.
     */
    private Input input;

    /**
     *tracker.
     */
    private Tracker tracker;

    /**
     * List for User action.
     */
    private ArrayList<UserAction> actions = new ArrayList<UserAction>();

    /**
     * Constructor with input tracker.
     * @param input input.
     * @param tracker tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     *Method fill action.
     */
    public void fillAction() {
        actions.add(new AddItem());
        actions.add(new showAllItem());
        actions.add(new FindItemByName());
        actions.add(new FindItemById());
        actions.add(new EditItem());
        actions.add(new DeleteItem());
        actions.add(new AddCommentsToItem());

   }

    /**
     *Method do action.
      * @param action string with action.
     */
   public void doAction(String action) {
       this.actions.get(Integer.valueOf(action) - 1).execute(this.input, this.tracker);
    }


    /**
     *The method show users menu
     */
    public void showMenu() {
        System.out.println("1. Add new item ");
        System.out.println("2. Show all item ");
        System.out.println("3. Find item by name ");
        System.out.println("4. Find item by id ");
        System.out.println("5. Edit item ");
        System.out.println("6. Delete item ");
        System.out.println("7. Add comments to item");
        System.out.println("8. Exit");
    }

    /**
     * Method print the question on monitor.
     * @return string with question.
     */
    public String  ask() {
        return this.input.ask("Choice your action");
    }


    /**
     *The method show Item for users
     *@param arrayItem
     */
    private void showItem(List<Item> arrayItem) {
        for (Item tmpItem : arrayItem) {
            if (tmpItem != null) {
                System.out.println(tmpItem.toString());
            }
        }
    }

    /**
     *The method show Item for users
     *@param printItem
     */

    private void showItem(Item printItem) {
        System.out.println(printItem.toString());
    }

    /**
     *
     */
    private class AddItem implements UserAction {

        /**
        *
        * @return
        */
        public int key() {

            final int key = 0;
            return key;
        }

        /**
         *
         * @param input
         * @param tracker
         */
        public void execute(Input input, Tracker tracker) {
           Item newItem = new Item(input.ask("please enter the name of item"), input.ask("please enter the description of item"));
           tracker.addNewItem(newItem);

        }

        /**
         *
         * @return
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }

    }

    /**
     *
     */
    private class showAllItem implements UserAction {

        /**
         *
         * @return
         */
        public int key() {
            final int key = 1;
            return key;
        }

        /**
         *
         * @param input
         * @param tracker
         */
        public void execute(Input input, Tracker tracker) {
            showItem(tracker.getAllItem());

        }

        /**
         *
         * @return
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all menu");
        }

    }

    /**
     *
     */
    private class FindItemByName implements UserAction {

        /**
         *
         * @return
         */
        public int key() {

            final int key = 1;

            return key;
        }

        /**
         *
         * @param input
         * @param tracker
         */
        public void execute(Input input, Tracker tracker) {
            String nameItem = input.ask("please enter the name of item");
            ArrayList<Item> findItem = tracker.findItemByName(nameItem);
            if (findItem.size() != 0) {
                showItem(findItem);
            }

        }

        /**
         *
         * @return
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name ");
        }

    }

    /**
     *
     */
    private class FindItemById implements UserAction {

        /**
         *
         * @return
         */
        public int key() {

            final int key = 2;

            return key;
        }

        /**
         *
         * @param input
         * @param tracker
         */
        public void execute(Input input, Tracker tracker) {
            Item  findItem  = tracker.findItemById(input.ask("please enter id Item"));
            if (findItem != null) {
                showItem(findItem);
            }
        }

        /**
         *
         * @return
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id");
        }

    }

    /**
     *
     */
    private class EditItem implements UserAction {
        /**
         *
         * @return
         */
        public int key() {
            final int key = 3;
            return key;
        }

        /**
         *
         * @param input
         * @param tracker
         */
        public void execute(Input input, Tracker tracker) {
            Item editItem = tracker.findItemById(input.ask("please enter id Item"));
            Item newEditItem = new Item(input.ask("please enter the name of item"), input.ask("please enter the description of item"));
            if (editItem != null) {
                newEditItem.setId(editItem.getId());
                tracker.editItem(newEditItem);
                showItem(editItem);
            }
        }

        /**
         *
         * @return
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }

    }

    /**
     *
     */
    private class DeleteItem implements UserAction {

        /**
         *
         * @return
         */
        public int key() {
            final int key = 4;
            return key;
        }

        /**
         *
         * @param input
         * @param tracker
         */
        public void execute(Input input, Tracker tracker) {
            Item deleteItem =  tracker.findItemById(input.ask("please enter id Item"));
            if (deleteItem != null) {
                tracker.deleteItem(deleteItem);
                showItem(tracker.getAllItem());
            }

        }

        /**
         *
         * @return
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }

    }

    /**
    *
    */
    private class AddCommentsToItem implements UserAction {

        /**
         *
         * @return
         */
        public int key() {
            final int key = 5;
            return key;
        }

        /**
         *
         * @param input
         * @param tracker
         */
        public void execute(Input input, Tracker tracker) {
            Comments comment = new Comments(input.ask("please enter comments to item"));
            Item editItem = tracker.findItemById(input.ask("please enter id Item"));
            editItem.addComment(comment);
        }

        /**
         *
         * @return
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add comments to item");
        }

    }

}