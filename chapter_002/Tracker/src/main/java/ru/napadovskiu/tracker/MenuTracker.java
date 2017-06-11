package ru.napadovskiu.tracker;

import ru.napadovskiu.items.Item;
import ru.napadovskiu.items.Comments;

/**
 *
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    /**
     *
     * @param input
     * @param tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     *
     */
    public void fillAction() {
        this.actions[0] = new AddItem();
        this.actions[1] = new showAllItem();
        this.actions[2] = new FindItemByName();
        this.actions[3] = new FindItemById();
        this.actions[4] = new EditItem();
        this.actions[5] = new DeleteItem();
        this.actions[6] = new AddCommentsToItem();
   }

    public void doAction(String action) {
        this.actions[Integer.valueOf(action) - 1].execute(this.input, this.tracker);
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

    public String  ask() {
        return this.input.ask("Choice your action");
    }


    /**
     *The method show Item for users
     *@param arrayItem
     */
    private void showItem(Item[] arrayItem) {
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
            return 0;
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
            return 1;
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
            return 1;
        }

        /**
         *
         * @param input
         * @param tracker
         */
        public void execute(Input input, Tracker tracker) {
            String nameItem = input.ask("please enter the name of item");
            Item[] findItem = tracker.findItemByName(nameItem);
            if (findItem.length != 0) {
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
            return 2;
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
            return 3;
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
            return 4;
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
            return 5;
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