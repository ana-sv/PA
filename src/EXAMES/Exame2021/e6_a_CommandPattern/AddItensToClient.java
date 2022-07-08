package EXAMES.Exame2021.e6_a_CommandPattern;

import java.util.ArrayList;


public class AddItensToClient implements ICommand {
    OnlineCommerce commerce;
    ArrayList<String> products; 
    int clientID; 


    public AddItensToClient(OnlineCommerce commerce, ArrayList<String> products, int clientID) {
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
            if( id==-1 || !commerce.removeItemFromCart(clientID, id) ) //
                return false;
        }
        return true;
    }
    
}
