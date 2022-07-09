package exercicios.Library_Files.model.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import exercicios.Library_Files.model.books.Book;
import exercicios.Library_Files.model.books.BookComparator;

public class Library implements Serializable{
    Set<Book> books;
    String name;

    public Library(String name) {
        this.name=name;
        books = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int addBook(Book book) {
        if (book==null)
            return -1;

        Book newBook = (Book) book.clone();
        if (!books.add(newBook))
            return -1;

        return book.getId();
    }

    public Book findBook(int id) {
        if (books ==null || books.size()==0)
            return null;
        for(Book book : books)
            if (id == book.getId())
                return (Book) book.clone();
        return null;
    }

    public Book findBook2(int id) {
        if (books ==null || books.size()==0)
            return null;
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            if (id == book.getId())
                return (Book) book.clone();
        }
        return null;
    }

    public boolean removeBook(int id) {
        if (books == null)
            return false;
        return books.remove(Book.getDummyBook(id));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Library: "+name);
        if (books ==null || books.size()==0)
            sb.append("The library is empty");
        else
            for(Book book : books)
                sb.append(String.format("\n%s",book.toString()));
        return sb.toString();
    }

    public String toStringOtherOrder() {
        StringBuilder sb = new StringBuilder("Library: "+name);
        if (books ==null || books.size()==0)
            sb.append("The library is empty");
        else {
            List<Book> orderSet = new ArrayList<>(books);
            Collections.sort(orderSet,new BookComparator());
            for (Book book : orderSet)
                sb.append(String.format("\n%s", book.toString()));
        }

        return sb.toString();
    }
}
