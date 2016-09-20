package ru.napadovskiu.tracker;

import jdk.internal.instrumentation.Tracer;

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
        System.out.println("3. Find irem by name and description ");
        System.out.println("4. Edit item ");
        System.out.println("5. Delete item ");
        System.out.println("6. Exit");

    }

   public void addNewItem(){

       String itemName = this.input.ask("please enter the name of task");
       String itemDescription = this.input.ask("please enter the description of task");

   }

    public void init(){
        boolean exit =false;
            this.showMenu();
//        do {
            //Integer userChoice = this.input.userChoice("Please make your choice");
//           if (userChoice.intValue() == 1){
//               this.addNewItem();// System.out.println("add new item");
//           }
//        } while(!exit );

    }



    public static void main(String[] args){
        Input consoleInput = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI(consoleInput,tracker).init();
//
//        Tracker tracker = new Tracker();
//        tracker.addNewItem(new Item(name,"firstItemDescription"));
//        for (Item item: tracker.showAllItem()){
//            System.out.println(item.getName());
//        }


    }

}
