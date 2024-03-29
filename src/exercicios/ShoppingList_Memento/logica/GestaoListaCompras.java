package exercicios.ShoppingList_Memento.logica;



import exercicios.ShoppingList_Memento.logica.memento.CareTaker;
import exercicios.ShoppingList_Memento.logica.memento.dados.ListaDeCompras;

public class GestaoListaCompras {
    private ListaDeCompras originator;
    private CareTaker careTaker;

    public GestaoListaCompras() {
        originator = new ListaDeCompras();
        careTaker = new CareTaker(originator);
    }

    public void acrescentaNovoProduto( String nome, int quantidade) {
        careTaker.gravaMemento();
        originator.acrescentaNovoProduto(nome, quantidade);
    }

    public void eliminaProduto( int indice) {
        careTaker.gravaMemento();
        originator.eliminaProduto(indice);
    }

    public void alteraQuantidade(int indice, int quantidade) {
        careTaker.gravaMemento();
        originator.alteraQuantidade(indice, quantidade);
    }


    public void undo() {
        careTaker.undo();
    }

    public void redo() {
        careTaker.redo();
    }

    // metodos que consultam

    public String toString() {
        return careTaker.toString() + "\n" + originator.toString();
        //     info acerca das pilhas undo/redo  + info acerca da lista de compras
    }
}
