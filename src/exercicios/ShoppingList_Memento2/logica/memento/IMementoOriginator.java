package exercicios.ShoppingList_Memento2.logica.memento;

import java.io.IOException;

public interface IMementoOriginator {
    Memento getMemento() throws IOException;
    void setMemento(Memento m) throws IOException, ClassNotFoundException;
}
