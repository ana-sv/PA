# Notes 


###### Exemplo Percentagens 

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