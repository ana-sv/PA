package exercicios.ShoppingList_Memento;

import java.io.IOException;

import exercicios.ShoppingList_Memento.logica.GestaoListaCompras;
import exercicios.ShoppingList_Memento.ui.texto.UITextoListaCompras;


public class AppListaDeCompras {
    public static void main(String[] args) throws IOException {
        GestaoListaCompras gestaolistaDeCompras = new GestaoListaCompras();
        UITextoListaCompras ui = new UITextoListaCompras(gestaolistaDeCompras);
        ui.corre();
    }
}
