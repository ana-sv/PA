package exercises.e19;

import java.util.*;

public class Library implements ILibrary {

    protected String name;
    protected List<Book> books;

    public Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }


    @Override
    public int addBook(String title, String[] authors) {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public int addBook(String title, List<String> authors) {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public Book getBook(int id) {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public boolean removeBook(int id) {
        // TODO Auto-generated method stub
        return false;
    }
}