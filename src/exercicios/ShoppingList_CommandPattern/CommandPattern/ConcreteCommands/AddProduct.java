package exercicios.ShoppingList_CommandPattern.CommandPattern.ConcreteCommands;

import exercicios.ShoppingList_CommandPattern.CommandPattern.CommandAdapter;
import exercicios.ShoppingList_CommandPattern.data.ShoppingList;

public class AddProduct extends CommandAdapter {
    // private <variables needed to execute this command>
    private String nomeProduto;
    private double quantidade;

    public AddProduct(ShoppingList receiver, String s, double d) {
        super(receiver);
        this.nomeProduto = s;
        this.quantidade = d;

    }

    @Override
    public boolean execute() {
        return receiver.addProduct(nomeProduto, quantidade);
    }

    @Override
    public boolean undo() {
        return receiver.removeProduct(nomeProduto, quantidade);
    }
}