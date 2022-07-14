package EXAMES.Exame2022.perg1_4;


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

        TypeA obj1 = new TypeA("a");
        System.out.println(obj1);

        TypeB obj2 = new TypeB("b");
        System.out.println(obj2);

        TypeA obj3 = obj2; 
        System.out.println(obj3);

        obj1.SetS("k");

        if(Math.random()<10.0)
            obj2.SetS("l");

        if(obj3 instanceof TypeB)
            obj3.SetS("m");

            System.out.println(obj1);
            System.out.println(obj2);
            System.out.println(obj3);
            System.out.println("End");
    }
    
}
