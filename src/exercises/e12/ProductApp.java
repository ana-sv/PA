package exercises.e12;

public class ProductApp {

    public static void main(String[] args) {

        Product a = new Product("Blue Gum");
        Product b = new Product(" Wonka's Whipple");
        Product c = new Product("FSwudge");

        Factory f = new Factory("WILLY WONKA AND THE CHOCOLATE FACTORY");
        System.out.println(f.toString());

        f.addProduct(a);
        f.addProduct(b);
        f.addProduct(c);
        System.out.println("\n**** Added Products: " + f.toString());
      
        f.testProducts();
        System.out.println("\n**** Tested Products " + f.toString());


        f.removeProduct(b);
        System.out.println("\n**** Removed Products " + f.toString());


    }

}
