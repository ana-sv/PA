package exercicios.e13.model;

import java.util.*;

public interface LibraryInterface {

    int addBook(String title, String[] authors);

    int addBook(String title, List<String> authors);

    Book getBook(int id);

    boolean removeBook(int id);
}