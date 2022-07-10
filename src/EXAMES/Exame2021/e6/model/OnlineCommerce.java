package EXAMES.Exame2021.e6.model;

public class OnlineCommerce implements IOnlineCommerce {

    public OnlineCommerce() {
    }

    @Override
    public int getItem(String itemName) {
        // TO DO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean withdrawFromClient(int value, int clientIBAN) {
        // TO DO Auto-generated method stub
        return false;
    }

    @Override
    public boolean depositIntoClient(int value, int clientIBAN) {
        // TO DO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addItemToCart(int clientID, int ItemID) {
        // TO DO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeItemFromCart(int clientID, int ItemID) {
        // TO DO Auto-generated method stub
        return false;
    }

    @Override
    public boolean emptyChart() {
        // TO DO Auto-generated method stub
        return false;
    }
    
}
