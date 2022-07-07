package exercicios.ShoppingList_CommandPattern.CommandPattern.ConcreteCommands;

import exercicios.ShoppingList_CommandPattern.CommandPattern.CommandAdapter;
import exercicios.ShoppingList_CommandPattern.data.ShoppingList;

public class RemoveProduct extends CommandAdapter {
    // private <variables needed to execute this command>
    private String nomeProduto;
    private double quantidade;

    public RemoveProduct(ShoppingList receiver, String s, double d) {
        super(receiver);
        this.nomeProduto = s;
        this.quantidade = d;

    }

    @Override
    public boolean execute() {
        return receiver.removeProduct(nomeProduto, quantidade);
    }

    @Override
    public boolean undo() {
        return receiver.addProduct(nomeProduto, quantidade);
    }
}