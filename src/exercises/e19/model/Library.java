package exercises.e19.model;

import java.util.*;

public class Library  {

    protected String name;
    protected List<Book> books;

    public Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public void addBook(OldBook b ) {
        this.books.add(b);
    }
    public void addBook(RecentBook b ) {
        this.books.add(b);
    }
    


    public Book getBook(int code) {
        for (Book b : books) {
            if (b.getCode() == code)
                return b;
        }
        return null;
    }

    public boolean removeBook(int code) {
        for (Book b : books) {
            if (b.getCode() == code){
                    books.remove(b);
                    return true;
            }
                
        }
      
        return false;
    }


    @Override
    public String toString() {
        return "Library [books=" + books + ", name=" + name + "]";
    }









}
