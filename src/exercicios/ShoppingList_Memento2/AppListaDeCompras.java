package exercicios.ShoppingList_Memento2;

import java.io.IOException;

import exercicios.ShoppingList_Memento2.logica.GestaoListaCompras;
import exercicios.ShoppingList_Memento2.ui.texto.UITextoListaCompras;


public class AppListaDeCompras {
    public static void main(String[] args) throws IOException {
        GestaoListaCompras gestaolistaDeCompras = new GestaoListaCompras();
        UITextoListaCompras ui = new UITextoListaCompras(gestaolistaDeCompras);
        ui.corre();
    }
}
