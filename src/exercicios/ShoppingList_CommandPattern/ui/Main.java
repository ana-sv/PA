package exercicios.ShoppingList_CommandPattern.ui;

import exercicios.ShoppingList_CommandPattern.CommandPattern.ShoppingListManager;

public class Main {
    public static void main(String[] args) {
        ShoppingListManager manager = new ShoppingListManager();
        ShoppingListUI ui = new ShoppingListUI(manager);
        ui.start();
    }
}
