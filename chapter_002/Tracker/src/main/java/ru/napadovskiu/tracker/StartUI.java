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
		*The main method 
	*/ 	
	public void init(){
        boolean exit =false;
        MenuTracker menuTracker = new MenuTracker(this.input,this.tracker);
        menuTracker.showMenu();
        do {
            String choiseAction = menuTracker.ask();
            if (Integer.valueOf(choiseAction) == 8){
                exit = true;
            }
            else {
                menuTracker.fillAction();
                menuTracker.doAction(choiseAction);
            }
        }
        while(!exit );
    }

    public static void main(String[] args){
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        StartUI startUI = new StartUI(input,tracker);
        startUI.init();
    }

}

