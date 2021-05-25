package pl.sda.project.skillRollGenerator.view.core;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItems = new ArrayList<>();
    public static Runnable DEFAULT_QUIT = ()-> System.exit(0);

    public void addMenuItem (MenuItem item) {
        menuItems.add(item);
    }

    public void print() {
        for (int i =0; i < menuItems.size(); i++){
            System.out.println((i + 1) + ". " + menuItems.get(i).label);
        }
    }

    private void runMenuAction (int option) {
       menuItems.get(option -1).action.run();
    }

    private boolean isItemAtMenu (int position){
        int index = position -1;
        return index >=0 && index <menuItems.size();
    }

    public boolean process (int option){
        if (isItemAtMenu(option)){
            runMenuAction(option);
            return true;
        } else {
            return false;
        }
    }
}
