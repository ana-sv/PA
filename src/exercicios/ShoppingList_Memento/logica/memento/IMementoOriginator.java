package exercicios.ShoppingList_Memento.logica.memento;

import java.io.IOException;

public interface IMementoOriginator {
    Memento getMemento() throws IOException;
    void setMemento(Memento m) throws IOException, ClassNotFoundException;
}
