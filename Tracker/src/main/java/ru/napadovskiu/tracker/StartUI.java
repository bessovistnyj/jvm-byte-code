package ru.napadovskiu.tracker;

import ru.napadovskiu.items.*;
import java.util.Arrays;
import java.util.Date;

public class StartUI {
    private Input     input;
    private Tracker   tracker;


    public StartUI(Input input, Tracker tracker){
        this.input = input;
        this.tracker = tracker;
    }

  	 /**
		*The method show users menu
	*/ 	
	public void showMenu(){
        System.out.println("1. Add new item ");
        System.out.println("2. Show all item ");
        System.out.println("3. Find item by name and description ");
        System.out.println("4. Find item by id ");
        System.out.println("5. Edit item ");
        System.out.println("6. Delete item ");
        System.out.println("7. Add comments to item");
        System.out.println("8. Exit");
    }

  	 /**
		*The method show Item for users
		*@param arrayItem 
	*/ 	
 	public void showItem(Item[] arrayItem){
        for(Item tmpItem : arrayItem){
            System.out.println(tmpItem.toString());
       }
   }

    /**
     *The method show Item for users
     *@param printItem
     */

    public void showItem(Item printItem){
        System.out.println(printItem.toString());
    }


    private Item takeItemFromArray(Item[] arrayItem){
       String counter = this.input.ask("please enter number delete item ");
       Integer i = new Integer(counter);
       return arrayItem[i-1];
   }

    /**
     * The metthod add new item to tracker
     * @param item
     */

   private void addNewItem(Item item){

        this.tracker.addNewItem(item);
   }

    /**
     * method show all item from tracker
     */
   private void showAllItem(){
       Item[] arrayItem  = this.tracker.getAllItem();
       if(arrayItem.length >0){
          this.showItem(arrayItem);
       }
   }


    /**
     * method find item by Id
     * @param id
     */
   private void findItemById(String id){
       Item findItem  = this.tracker.findItemById(id);
       if(findItem !=null) {
           this.showItem(findItem);
       }
   }

    /**
     * method adds comment to item
     * @param idItem
     */
   private void addCommentsToItem(String idItem){
      Comments comment = new Comments(this.input.ask("please enter comments to item"));
       Item editItem = this.tracker.findItemById(idItem);
       editItem.addComment(comment);
   }

    /**
     * method find item by name and description
     * @param name
     * @param desc
     */
   private void findItem(String name, String desc){
       Item[] findItem = this.tracker.findItem(name,desc);
       if(findItem.length !=0){
           this.showItem(findItem);
       }
   }

    /**
     * method edit item i tracker
     * @param editItem
     */
   private void editItem(Item editItem){
       Item newEditItem = new Item(this.input.ask("please enter the name of item"),this.input.ask("please enter the description of item"));
       if(editItem !=null){
           newEditItem.setId(editItem.getId());
           this.tracker.editItem(newEditItem);
           this.showItem(editItem);
       }
   }

    /**
     * metho delete item from tracker
     * @param deleteItem
     */
   private void deleteItem(Item deleteItem){
      if(deleteItem !=null) {
          this.tracker.deleteItem(deleteItem);
          this.showAllItem();
      }
   }

    /**
		*The main method 
	*/ 	
	public void init(){
        boolean exit =false;
        do {
            String  action = this.input.ask("Choice your action");
            switch (Integer.valueOf(action)){
                case 1 :
                    this.addNewItem(new Item(this.input.ask("please enter the name of item"),this.input.ask("please enter the description of item")));
                    break;
                case 2 :
                    this.showAllItem();
                    break;
                case 3 :
                    this.findItem(this.input.ask("please enter the name of item"),this.input.ask("please enter the description of item"));
                    break;
                case 4 :
                    this.findItemById(this.input.ask("please enter id Item"));
                    break;
                case 5 :
                    this.editItem(this.tracker.findItemById(this.input.ask("please enter id Item")));
                    break;
                case 6 :
                    this.deleteItem(this.tracker.findItemById(this.input.ask("please enter id Item")));
                    break;
                case 7 :
                    this.addCommentsToItem(this.input.ask("please enter id Item"));
                    break;
                case 8 :
                    exit = true;
                    break;
            }
        } while(!exit );

    }

    public static void main(String[] args){
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        StartUI startUI = new StartUI(input,tracker);
        startUI.showMenu();
        startUI.init();

    }


}

