
# Exame 2022 - Época Normal 
## 1 
```java 
class TypeA{
    String s; 
    public TypeA(String s){
        this.s = s; 
        System.out.println("TypeA:Constructor");
    }

    public void SetS(String s){ this.s = s; }

    @Override
    public String toString(){
        return "Type=" + s +" ; "; 
    }
}

class TypeB extends TypeA{
    public TypeB(String s){
        super(s);
        System.out.println("TypeB:Constructor");
    }

    @Override
    public String toString(){
        return "TypeB=" + s + "; " + super.toString();
    }
}


public class Main1 {

    public static void main( String[] args ){
        System.out.println("Begin");

        TypeA obj1 = new TypeA("a"); //Construtor de TypeA faz print de "TypeA:Constructor "
        System.out.println(obj1); // print "Type=a ;"  

        TypeB obj2 = new TypeB("b"); //Contrutor de TypeA , que é a classe base faz print de "TypeA:Constructor " e depois construtor de TypeB que faz "TypeB:Constructor"
        System.out.println(obj2); // print "TypeB=b; Type=b ; " TypeB=b do objb e Typeb do super da classe base 

        TypeA obj3 = obj2; // nada 
        System.out.println(obj3); // o mesmo que System.out.println(obj2), faz print de "TypeB=b; Type=b ; "

        obj1.SetS("k"); // obj1 passa a k

        if(Math.random()<10.0) // percecntagem baixa para fazer mossa 
            obj2.SetS("l");

        if(obj3 instanceof TypeB) // true porque TypeB extends TypeA e sendo que  TypeA obj3 = obj2; os dois ficam com m ?????
            obj3.SetS("m");

            System.out.println(obj1); // print Type=k ; 
            System.out.println(obj2); // print TypeB=m; Type=m ; 
            System.out.println(obj3); // print TypeB=m; Type=m ;
            System.out.println("End");
    }
}
```


####  Output do programa: 
```java
Begin 
TypeA:Constructor     
Type=a ;              
TypeA:Constructor      
TypeB:Constructor    
TypeB=b; Type=b ;     
TypeB=b; Type=b ;      
Type=k ;               
TypeB=m; Type=m ;     
TypeB=m; Type=m ;      
End
```

## 2 
```java
class ObjectBase{
    protected double d ; 

    public ObjectBase(double d){this.d = d; };

    @Override
    public boolean equals(Object o){
        if ( this == o) return true; 
        if ( o instanceof ObjectBase other ){ return d == other.d; }
        return false; 
    }

    @Override
    public int hashCode(){ return 0; }

}

class Object1 extends ObjectBase{
    static int count = 0; 

    public Object1(double d){ super(d); }; 

    @Override
    public int hashCode(){
        return count++ / 2; 
    }
}

class Object2 extends ObjectBase{
    public Object2 ( double d ){ super(d); }
}

class Object3 extends ObjectBase{
    static int count = 1; 
    public Object3(double d){
        super(d); 
    }

    @Override 
    public int hashCode(){
        return count++ % 2; 
    }

}



public class Main2 {

    public static void main( String[] args ){
        Set<Object> set = new HashSet<>();

        for( int i=0; i<3; i++){
            System.out.println( set.add( new Object1(1.0)));
            System.out.println( set.add( new Object2(2.0)));
            System.out.println( set.add( new Object3(3.0)));
        }
        System.out.println(set.size());
    }
    
}
```

####  Output do programa: 
```java
true
true
true
false
false
true
true
false
false
5
```

Justificação : 
> Á medidade que os static int count vão sendo incrementados , surgem objetos iguais. Como o hashSet não permite Objectos iguals, os objectos duplicados não poderão ser adicionados ao hashSet devolvendo assim "false" nessas ocasiões. Assim , contado os "true" que o programa mostra, as operações de adicionar elementos ao hashSet bem sucedidas, temos um hashSet com um tamanho de 5. 



## 3
```java
interface InterfA{
    void func1();
    void func2();
}

interface InterfB extends InterfA{
    default void func1(){};
    void func3(); 
}

final class ClassC extends ClassA {  // class adicionada
}

non-sealed class ClassB extends BaseClass{ // class adicionada
    @Override
    public void func1() { }
    @Override
    public void func2() {  }
}


sealed class ClassA extends BaseClass implements InterfB permits ClassC  {  // class adicionada
    @Override
    public void func1() { }
    @Override
    public void func2() {  }
    @Override
    public void func3() { }
}

sealed abstract class BaseClass implements InterfA permits ClassA, ClassB{
}

public class Main3 {
    public static void main( String[] args ){
        ClassA objA = new ClassA();
        BaseClass objA1 = objA; 
        InterfB objA2 = objA;
        ClassB objB = new ClassB();
        BaseClass objB1 = objB;
        ClassC objC = new ClassC();
        ClassA objC1 = objC; 
    }
}
```
 
#### Notas sobre sealed classes: 

> Sealed classes permitem como subclasses APENAS as que foram indicadas na sua declaração; 

> Uma classe derivada de uma classe sealed tem que ser: final ou sealed ou non-sealed

> Neste caso: 
» BaseClasse permits ClassA e ClassB  -> entao ClassA E ClassB tem que ser final,sealed ou non-sealed 
» apenas ClassC pode derivar a ClassA -> então sealed ClassA permits ClassC 



## 4
```java 
class MyException extends InvalidObjectException{
    public MyException(String reason){
        super(reason);
    }

    @Override
    public String toString(){
        return "Error: "+super.toString();
    }
}

class Project{
    String name;
    String teacher; 
    String student; 

    public Project(String name, String teacher, String student) throws Exception{
        this.name = name; 
        this.teacher = teacher;
        this.student = student; 
        if( teacher.equals(student))
            throw new MyException( "Teacher and Student have the same name");
    }

    @Override
    public String toString(){
        return String.format("%s / %s / %s ", name, teacher,student);
    }
}

public class Main4 {

    public static Project createProject(String name, String teacher, String student){
        try{
            return new Project(name, teacher, student);
        } catch(MyException e){
            System.out.println("Msg A");
        }catch(Exception e){
            System.out.println("Msg B");
        } finally{
            System.out.println("Msg C");
        }
        System.out.println("Msg D");
        return null; 
    }

    public static void main(String[] args ){
        System.out.println("Begin");
        Project a = createProject("A", "B", "C");  // Msg C
        Project b = createProject("A", "B", "B"); // Msg A Msg C Msg D
        Project c = createProject("A", null, "C");  // Msg B Msg C Msg D
        System.out.println(a+"\n"+b+"\n"+c); // A / B / C null null 
        System.out.println("End");
    }
    
}

```
*
#### Output do Programa 
```java 
Begin
Msg C
Msg A
Msg C
Msg D
Msg B
Msg C
Msg D
A / B / C 
null
null
End
````


## 5.a) 

> #**Diagrama de estados**
>  Estados : EMVOO , POUSADA , PRONTA, MORTA
>  Transições: mexe(), pica(); descola(); tentaEsmagar(); 


# ... 