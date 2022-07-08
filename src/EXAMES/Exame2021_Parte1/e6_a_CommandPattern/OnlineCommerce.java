package EXAMES.Exame2021_Parte1.e6_a_CommandPattern;

public interface OnlineCommerce {
     // obtem código(ID) do item dado po o nome
     // retorna -1 se não existir 
     int getItem(String itemName);

     // retira dinheiro da conta do cliente
     // retorna false se não tiver suficiente 
    boolean withdrawFromClient(int value, int clientIBAN); 

    // repoe dinheiro da conta do cliente 
    // sucede bem sempre
    boolean depositIntoClient(int value, int clientIBAN); 

    // adiciona o item ao carrinho de compras
    // item fica logo reservado 
    // fala se não houver stock
    boolean addItemToCart( int clientID, int ItemID);

    // remove do carrinho de compras 
    // item fica "des-reservado"
    // falha se nao estivesse no carrinhp
    boolean removeItemFromCart(int clientID, int ItemID);

    // esvazia carrinho de compras 
    // após finalizar todas as compras do cliente 
    boolean emptyChart();

}
