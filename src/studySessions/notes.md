# Notes 

#

#### String , StringBuffer & StringBuilder 

``` java
String 
> strings are immutable
> a new string is created in the memory every time we change the value of the string

StringBuilder 
> not synchronized 
> better in single-threaded enviromments
> mutable
> any change induced will modify the existing sequence of characteres created in the memory 

StringBuffer
> synchronized 

``` 

#

#### Exemplo Percentagens 

``` java
    public boolean testUnit() {
        Random random = new Random();
        if (random.nextInt(100) < 90  ) {  // 90% das x é aprovado
            setState("approved");
            return true;
        }
        setState("disapproved");
        return false;
    }

``` 

#

#### Exemplo equals

``` java
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
  
  ``` 

  #