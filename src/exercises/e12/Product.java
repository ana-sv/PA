package exercises.e12;

import java.time.LocalDate;
import java.util.Random;

public class Product {
    private static int nextCode = 0; 

    private int serialNumber;
    private String name; 
    private String state;
    private LocalDate date;

    public Product( String n) {
        this.name = n; 
        this.serialNumber = nextCode;
        this.state = "not tested";
        this.date = LocalDate.now();
        nextCode++; 
    }

    protected void setState(String s) {
        state = s;
    }

    protected String getState() {
        return state;
    }

    public boolean testUnit() {
        Random random = new Random();
        if (random.nextInt(100) < 90  ) {
            setState("approved");
            return true;
        }
        setState("disapproved");
        return false;
    }

    @Override
    public String toString() {
        return "\n>Serial Number: " + serialNumber + " - Name: " + name + " - Date: " + date + " - State: " + state ;
    }

    @Override
    public int hashCode() {
        return this.serialNumber;
    }


    @Override
    public boolean equals(Object o) {
 
        // If the object is compared with itself then return true 
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Product or not
          "null instanceof [type]" also returns false */
        if (o==null || !(o instanceof Product)) {
            return false;
        }
         
        // typecast o to Product so that we can compare data members
        Product c = (Product) o;
         
        // Compare the data members and return accordingly
        return this.serialNumber == c.serialNumber;
    }

}





