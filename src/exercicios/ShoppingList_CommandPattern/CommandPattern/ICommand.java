package exercicios.ShoppingList_CommandPattern.CommandPattern;

public interface ICommand {
    boolean execute();
    boolean undo();
    }