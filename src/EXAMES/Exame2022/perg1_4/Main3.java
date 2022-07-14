package EXAMES.Exame2022.perg1_4;


interface InterfA{
    void func1();
    void func2();
}

interface InterfB extends InterfA{
    default void func1(){};
    void func3(); 
}

final class ClassC extends ClassA {

}

non-sealed class ClassB extends BaseClass{

    @Override
    public void func1() {
    }

    @Override
    public void func2() {
    }

}


sealed class ClassA extends BaseClass implements InterfB permits ClassC  {

    @Override
    public void func1() {
    }

    @Override
    public void func2() {
    }

    @Override
    public void func3() {
    }



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
