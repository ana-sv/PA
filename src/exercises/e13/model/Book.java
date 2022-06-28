package exercises.e13.model;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Book {
    private static int nextcode = 0;
    private int code;
    protected String title;
    protected List<String> authors;

    public Book(String title, String[] authors) {

        this.title = title;
        this.authors = Arrays.asList(authors);
        code = nextcode++;
    }

    public Book(String title, List<String> authors) {
        code = nextcode++;
        this.title = title;
        this.authors = new ArrayList<>(authors);

    }

    public Book(int code) { // para o indexOf
        this.title = null;
        this.authors = null;
        this.code = code;
    }

    public int getCode() {
        return code;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getAuthor(int index) {
        if (index > 0 || index >= authors.size()) {
            return null;
        }
        return authors.get(index);
    }

    public void setAuthors(List<String> authors) {
        this.authors = new ArrayList<>(authors);
    }

    public void setAuthors(String[] authors) {
        this.authors.addAll(Arrays.asList(authors));
    }

    public void addAuthor(String author) {
        authors.add(author);
    }

    public boolean removeAuthor(String author) {
        return authors.remove(author);
    }

    public String removeAuthor(int index) {
        return authors.remove(index);
    }
    @Override
    public String toString(){
        String str; 
        str = "\n[ "+ code +" ] Title: " + title + " Authors: ";
        for( String s : authors)
            str = s + " ";
        return  str;
    }

    @Override
    public boolean equals( Object o ){

        if( o == this )  // se é o mesmo
            return true;

        if( o == null || !( o instanceof Book) )  // se não é da mesma classe 
            return false; 

        Book b = (Book) o;           // transforma na mesma classe para testar os valores de um atributo 
        return this.code == b.code; // e tem o mesmo code
    } 

    @Override
    public int hashCode(){
        return this.code; 
    }


    
}
