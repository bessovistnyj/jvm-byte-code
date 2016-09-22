package ru.napadovskiu.tracker;

import ru.napadovskiu.items.*;

public class StartUI {
    private Input     input;
    private Tracker   tracker;


    public StartUI(Input input, Tracker tracker){
        this.input = input;
        this.tracker = tracker;
    }

    public void showMenu(){
        System.out.println("1. Add new item ");
        System.out.println("2. Show all item ");
        System.out.println("3. Find item by name and description ");
        System.out.println("4. Find item by id ");
        System.out.println("5. Edit item ");
        System.out.println("6. Delete item ");
        System.out.println("7. Exit");

    }

    public void showItem(Item[] arrayItem){
       //
       Integer counter =1;
        for(Item tmpItem : arrayItem){

           String itemId    = tmpItem.getId();
           String itemName  = tmpItem.getName();
           String itemDesc  = tmpItem.getDescription();
           System.out.println(counter+". "+itemId+" "+ itemName +" "+itemDesc+" ");
           counter++;
       }
   }

    private Item takeItemFromArray(Item[] arrayItem){
       String counter = this.input.ask("please enter number delete item ");
       Integer i = new Integer(counter);
       return arrayItem[i-1];
   }

      public void init(){
        boolean exit =false;
        do {
            String  action = this.input.ask("Choice your action");
            if (action.equals("1")){
                this.tracker.addNewItem(new Item(this.input.ask("please enter the name of item"),this.input.ask("please enter the description of item")));
            }
            if (action.equals("2")){
                Item[] arrayItem  = this.tracker.showAllItem();
                this.showItem(arrayItem);
            }
            if (action.equals("3")){
                Item[] findItem = this.tracker.findItem(this.input.ask("please enter the name of item"),this.input.ask("please enter the description of item"));
                this.showItem(findItem);
            }
            if (action.equals("4")){
                Item[] findItem = this.tracker.findItem(this.input.ask("please enter id Item"));
                this.showItem(findItem);
            }
            if (action.equals("5")){
                Item[] findItem = this.tracker.findItem(this.input.ask("please enter id Item"));
                Item editItem = new Item(this.input.ask("please enter the name of item"),this.input.ask("please enter the description of item"));
                if (findItem.length > 0 && findItem.length == 1){
                    editItem.setId(findItem[0].getId());
                    this.tracker.editItem(editItem);
                }else{
                    editItem.setId(takeItemFromArray(findItem).getId());
                    this.tracker.editItem(editItem);
                }
            }
            if (action.equals("6")){
                Item[] findItem = this.tracker.findItem(this.input.ask("please enter id Item"));
                if (findItem.length > 0 && findItem.length == 1){
                    this.tracker.deleteItem(findItem[0]);
                }else{
                    this.tracker.deleteItem(takeItemFromArray(findItem));
                }
            }
            if (action.equals("7")){
                exit = true;
            }
        } while(!exit );

    }

    public static void main(String[] args){
        Input consoleInput = new ConsoleInput();
        Tracker tracker = new Tracker();
        StartUI userAction = new StartUI(consoleInput,tracker);
        userAction.showMenu();
        userAction.init();
//        String[] params = new String[]{"1","Task id","Task name","Task desc","1","Task id","","","7"};
//        Tracker tracker = new Tracker();
//        Input input = new StubInput(params);
//        new StartUI(input,tracker).init();
    }

}
