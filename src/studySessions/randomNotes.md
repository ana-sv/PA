# Random Notes 

### Deserialização Exemplo
``` java
    MyObject load(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filename))) {
            return (MyObject) ois.readObject();
        } catch (Exception e) {
            System.err.println("Error loading data");
        }
        return null;
``` 

### Serialização Exemplo
``` java
    void save(String filename, MyObject obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            oos.writeObject(obj);
        } catch (Exception e) {
            System.err.println("Error saving data");
        }
    }
``` 


#

#### Sorting  HashMaps , Comparable & Comparator 
**> exercicio 19 e 20**

- [ Comparable vs Comparator in Java ](https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/)

``` java
public class Book implements Comparable<Book>{
// ...
        @Override
        public int compareTo(Book o) {
            return id - o.id;
                        //Another example: return title.compareTo(o.title);
        }
}
// ...
``` 


``` java

public class BookComparator implements Comparator<Book> {
// ...
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
// ...
}
``` 

- [ Sorting a HashMap according to keys  ](https://www.geeksforgeeks.org/sorting-hashmap-according-key-value-java/)
``` java
    public String listaCartoesOrdenadosNumero() {
        String s = "";

        TreeMap<Integer, Cartao> sorted = new TreeMap<Integer, Cartao>();
        sorted.putAll(this.cartoes);

        for (Map.Entry<Integer, Cartao> entry : sorted.entrySet()) {
            s += entry.getKey() + " [" + entry.getValue().getSaldo() + "] \n";
        }
        return s;
    }
``` 


- [ Sorting a Hashmap according to values ](https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/ )
``` java
    public String listaCartoesOrdenadosSaldo() {
        String s = "";

        HashMap<Integer, Cartao> temp = cartoes.entrySet().stream()
        .sorted((i1, i2)-> i1.getValue().compareTo(i2.getValue()))
            .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (e1, e2) -> e1, LinkedHashMap::new));


            for( Map.Entry<Integer,Cartao> n: temp.entrySet()){
                s +=  n.getKey() + " [" + n.getValue().getSaldo() + "] \n";
            }
       
        return s;
    }
```

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

 - [ Difference Between StringBuffer and StringBuilder in Java -  GeekForGeeks ](https://www.geeksforgeeks.org/difference-between-stringbuffer-and-stringbuilder-in-java/?ref=rp)

 - [ String vs. StringBuilder vs. StringBuffer in Java  | Geekific  ](https://www.youtube.com/watch?v=_drNcLWgUlE&ab_channel=Geekific)

  - [ StringTokenizer Class in Java  -  GeekForGeeks ]( https://www.geeksforgeeks.org/stringtokenizer-class-in-java/ )

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

#### Exemplo Random 
``` java
import java.util.concurrent.ThreadLocalRandom;

// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive
int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
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

  #### Herança vs Composição 

  > **Composição**: um objecto composto por outros, tem outros objectos como atributos;
  > **Herança** : um objecto é definido como uma especialização de um outro + genérico; todas as caracteristicas que definem um tipo de objecto base são herdadas pelo novo objetcto; uma nova classe *extends* classe base

  > - Em java não existe herança multipla
  > - Referem-se caracteristicas da classe base usando *super*
  > - A classe derivada tem acesso aos metodos e variavies protected and public da classe base;

  > - Se classe base tem um construtor por omissão este é automaticamente chamado aquando a criação de um objecto da classe derivada;
  > - Se classe base ano tem construtor por omissão então a classe derivada tem que definir um construtor que permita chamar um construtor da classe base;

  > - Os comportamentos/métodos definidos nas classes base podem ser redefinidos nas classes derivadas; devem ser marcadas com a notação @Override 

  #




## Java Help Links 

 - [ Generics and Wildcards in Java Made Simple | Geekific ](https://www.youtube.com/watch?v=vqjA6dqugq8&ab_channel=Geekific/)

 - [ Arrays in Java -  GeekForGeeks ](https://www.geeksforgeeks.org/arrays-in-java/)

 - [ Operators in Java  -  GeekForGeeks ](https://www.geeksforgeeks.org/operators-in-java/)

 - [ Inheritance in Java  -  GeekForGeeks ](https://www.geeksforgeeks.org/inheritance-in-java/)

  - [ Access Modifiers in Java -  GeekForGeeks  ]( https://www.geeksforgeeks.org/access-modifiers-java/ )

  - [ equals() and hashCode() methods in Java  -  GeekForGeeks ](https://www.geeksforgeeks.org/equals-hashcode-methods-java/)

 - [ HashMap in Java with Examples ]( https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/)

- [ HashMap Class Methods in Java with Examples ]( https://www.geeksforgeeks.org/hashmap-class-methods-java-examples-set-1-put-get-isempty-size/?ref=rp )

- [ HashSet in Java ]( https://www.geeksforgeeks.org/hashset-in-java/ )

- [ How to sort HashSet in Java ](https://www.geeksforgeeks.org/how-to-sort-hashset-in-java/ )

- [ Singleton ](https://www.geeksforgeeks.org/singleton-class-java/)

## Java FX Help Links

- [ Setting up environment for GUI development with JavaFX in VS Code Editor.   ](https://www.youtube.com/watch?v=UzPFlpSrGI8&ab_channel=Innovator )

- [  Alert with examples -  GeekForGeeks ](https://www.geeksforgeeks.org/javafx-alert-with-examples/ )

- [ JavaFX Java GUI Tutorial - 30 - Binding Properties Example ]( https://www.youtube.com/watch?v=6Zi2L0kHSx4&ab_channel=thenewboston )


- [  ]( )

- [  ]( )


## Java Quiz 

- [ w3schools basic quiz ]( https://www.w3schools.com/quiztest/quiztest.asp?qtest=JAVA )