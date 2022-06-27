package exercises.e12;

import java.util.ArrayList;

public class Factory {
    protected String name; 
    protected ArrayList<Product> products;


    public Factory( String n){
        this.name = n ; 
        products = new ArrayList<Product>();
    }

    public boolean addProduct(Product a){
        return products.add( a );
    }

    public boolean removeProduct( Product r){
            return products.remove(r); 
    }

    public void removeProductReproved(){
         for ( Product p: products ){
            if (p.getState() == "reproved")
                  removeProduct(p); 
         }
    }

    public void testProducts(){
        for( Product p : products ){
            p.testUnit();
        }
    }

    @Override
    public String toString(){
        return "\n\nFactory Name: "+ name + "\nProducts: " + products.toString(); 
    }

    
}
