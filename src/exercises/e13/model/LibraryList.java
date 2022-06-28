package exercises.e13.model;

import java.util.*;

public class LibraryList implements LibraryInterface {

    protected String name;
    protected List<Book> books;

    public LibraryList(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public int addBook(String title, String[] authors) {
        Book newBook = new Book(title, authors);
        books.add(newBook);
        return newBook.getCode();
    }

    public int addBook(String title, List<String> authors) {
        Book newBook = new Book(title, authors);
        books.add(newBook);
        return newBook.getCode();

    }

    public Book getBook(int code) {
        int index = this.books.indexOf(new Book(code));

        if (index < 0) {
            return null;
        }

        return this.books.get(index);

    }

    public boolean removeBook(int code) {
        int index = this.books.indexOf(new Book(code));

        if (index < 0) {
            return false;
        }

        this.books.remove(index);
        return true;

    }

    @Override
    public String toString() {
        return "Biblioteca " + name + ":\n" + books;

    }
}