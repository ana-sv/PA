package exercicios.ShoppingList_CommandPattern.CommandPattern;
// Facade

import exercicios.ShoppingList_CommandPattern.CommandPattern.ConcreteCommands.AddProduct;
import exercicios.ShoppingList_CommandPattern.CommandPattern.ConcreteCommands.RemoveProduct;
import exercicios.ShoppingList_CommandPattern.data.ShoppingList;

//  ReceiveManager 

public class ShoppingListManager {

    ShoppingList rc;
    CommandManager cm;

    public ShoppingListManager() {
        rc = new ShoppingList();
        cm = new CommandManager();
    }

    // public boolean concreteCommand1(<parameters>) {
    // return cm.invokeCommand(new ConcreteCommand1(rc,<parameters>)); }

  public boolean  addProduct(String readString, double readNumber) {
        return cm.invokeCommand(new AddProduct(rc, readString, readNumber));
    }

    public boolean removeProduct(String readString, double readNumber) {
        return cm.invokeCommand(new RemoveProduct(rc, readString, readNumber));
    }
    

    // ...
    public boolean hasUndo() {
        return cm.hasUndo();
    }

    public boolean undo() {
        return cm.undo();
    }

    public boolean hasRedo() {
        return cm.hasRedo();
    }

    public boolean redo() {
        return cm.redo();
    }
    // ...

    @Override
    public String toString() {
        return rc.toString();
    }

}