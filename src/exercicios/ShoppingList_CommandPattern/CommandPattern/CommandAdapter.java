package exercicios.ShoppingList_CommandPattern.CommandPattern;

import exercicios.ShoppingList_CommandPattern.data.ShoppingList;

public abstract class CommandAdapter implements ICommand {  // só é public porque eu tenho em package diferente que os concrete commands

    protected ShoppingList receiver; // ReciverClass

    protected CommandAdapter(ShoppingList receiver) {
        this.receiver = receiver;
    }
}