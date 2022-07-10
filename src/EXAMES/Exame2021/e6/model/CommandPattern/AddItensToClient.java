package EXAMES.Exame2021.e6.model.CommandPattern;

import java.util.ArrayList;

import EXAMES.Exame2021.e6.model.IOnlineCommerce;


public class AddItensToClient implements ICommand {  // Concrete Command
    IOnlineCommerce commerce;
    ArrayList<String> products; 
    int clientID; 


    public AddItensToClient(IOnlineCommerce commerce, ArrayList<String> products, int clientID) {
        this.commerce = commerce;
        this.products = products;
        this.clientID = clientID;
    }

    @Override
    public boolean execute() {
        for( String p : products){
            int id = commerce.getItem(p);   // obtem o id do produto
            if( id==-1 || !commerce.addItemToCart(clientID, id) ) //
                return false;
        }
        return true;
    }

    @Override
    public boolean undo() {
        for( String p : products){
            int id = commerce.getItem(p);   // obtem o id do produto
            if( id==-1 || !commerce.removeItemFromCart(clientID, id) ) 
                return false;
        }
        return true;
    }
    
}
