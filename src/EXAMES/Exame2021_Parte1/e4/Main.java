package EXAMES.Exame2021_Parte1.e4;

import java.util.ArrayList;
import java.util.List;



public class Main{
    
    public static void main(String [] args ){
        List<AnimalEstimacao> animais = new ArrayList<>();
        animais.add( new Cao() ); 
        animais.add( new Gato() );
        for( AnimalEstimacao a : animais ){
            a.produzSom();
           /*
            if( a.getEspecie().equals("Cao")){
                a.produzSom();
            }else if(a.getEspecie().equals("Gato")){
                a.produzSom();
            }*/
        }
    }

}

abstract class AnimalEstimacao{
    private String especie;
    public AnimalEstimacao(String especie){
        this.especie= especie;
    }
    public String getEspecie(){
        return especie;
    }
    public void setEspecie(String especie){
        this.especie = especie;
    }
    public void produzSom(){
    }
}

class Cao extends AnimalEstimacao{
    public Cao(){ super("Cao"); }    //erro: public Cao{ setEspecie("Cao");}
    
      public void ladrar(){ System.out.println("AU AU AU"); }
    @Override                                    
     public void produzSom(){ ladrar(); }
   
}

class Gato extends AnimalEstimacao{
    public Gato(){ super("Gato"); }    // erro: public Cao{ setEspecie("Cao");}
    public void miar(){ System.out.println("MIAU MIAU MIAU"); };
    @Override
    public void produzSom(){ miar(); }
}


