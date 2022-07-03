# Notes 

#







#### Comparable & Comparator 
*exercício 19*

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

  
