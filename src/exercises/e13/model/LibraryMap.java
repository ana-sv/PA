package exercises.e13.model;

import java.util.*;

public class LibraryMap {

    protected String name;
    protected Map<Integer, Book> books; // using HasMap

    public LibraryMap(String name) {
        this.name = name;
        books = new HashMap<>();
    }

    public void addBook(String title, String[] authors) {
        Book newBook = new Book(title, authors);
        books.put(newBook.getCode(), newBook);

    }

    public void addBook(String title, List<String> authors) {
        Book newBook = new Book(title, authors); // Book tem vários construtores
        books.put(newBook.getCode(), newBook);
    }

    public Book getBook(int code) {
        return books.get(code); // nao rebenta, devolve null se não existir code
    }

    public boolean removeBook(int code) {
        if (books.remove(code) == null)
            return false;
        return true;
    }

    @Override
    public String toString() {
        String s;
        Collection<Book> colBooks = books.values();

        s = name + "\n";

        for (Book b : colBooks)
            s += b + "\n";

        return s;

    }
}
