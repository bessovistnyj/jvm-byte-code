package ru.napadovskiu.tracker;

import jdk.internal.instrumentation.Tracer;

import ru.napadovskiu.items.*;



public class StartUI {
    private Input input;
    private Tracker tracker;

    public StartUI(Input input, Tracer tracker){
        this.input = input;
        this.tracker = tracker;
    }


   public void addNewItem(){

       String itemName = this.input.ask("please enter the name of task");
       String itemDescription = this.input.ask("please enter the description of task");

   }

    public void init(){
        boolean exit =false;


        do {
            this.input.showMenu();
            Integer userChoice = this.input.makeChoice("Please make your choice");
            if (userChoice.intValue() == 1){
               this.addNewItem();// System.out.println("add new item");
            }
            if (userChoice.intValue() == 2){
                System.out.println("Edit item");
            }
            if (userChoice.intValue() == 3){
                System.out.println("Show all item");
            }
            if (userChoice.intValue() == 4){
                System.out.println("Find item by name and description");
            }
            if (userChoice.intValue() == 5){
                System.out.println("Delete item");
            }
            if (userChoice.intValue() == 0){
                exit = true;
            }


        } while(!exit );

    }



    public static void main(String[] args){
        Input consoleInput = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI(consoleInput,).init();
//
//        Tracker tracker = new Tracker();
//        tracker.addNewItem(new Item(name,"firstItemDescription"));
//        for (Item item: tracker.showAllItem()){
//            System.out.println(item.getName());
//        }


    }

}
