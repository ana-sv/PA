package exercises.e19.model;

import java.util.List;

public class RecentBook extends Book {

    protected String ISBN; 
    protected Double price;


  public RecentBook(String title, List<String> authors, String ISBN, Double price) {
        super(title, authors);
        this.ISBN = ISBN;
        this.price = price;
    }

    public RecentBook(String title, String[] authors, String ISBN, Double price) {
        super(title, authors);
        this.ISBN = ISBN;
        this.price = price;
    } 

    public RecentBook(String title, String authors, String ISBN, Double price) {
        super(title, authors);
        this.ISBN = ISBN;
        this.price = price;
    } 

    public Double getPrice(){
        return this.price; 
    }

    public void changePrice( Double newPrice){
        this.price = newPrice; 
    }

    public String getISBN(){
        return this.ISBN;
    }

    
    public int getCode(){
        return super.getCode();
    }


    
}
