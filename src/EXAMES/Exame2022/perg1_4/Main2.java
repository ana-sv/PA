package EXAMES.Exame2022.perg1_4;


import java.util.HashSet;
import java.util.Set;

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
