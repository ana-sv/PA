package exercises.e19.model;

import java.util.List;

public class OldBook extends Book {

    protected int numCopies;

    public OldBook(String title, String[] authors, int numCopies) {
        super(title, authors);
        this.numCopies = numCopies;
    }

    public OldBook(String title, List<String> authors, int numCopies) {
        super(title, authors);
        this.numCopies = numCopies;        
    }
    public OldBook(String title, String authors, int numCopies) {
        super(title, authors);
        this.numCopies = numCopies;        
    }

    public int getNumCopies(){
        return this.numCopies; 
    }

    public int getCode(){
        return super.getCode();
    }

    




}
