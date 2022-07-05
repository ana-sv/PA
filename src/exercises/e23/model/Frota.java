package exercises.e23.model;

import java.util.HashSet;

import exercises.e23.model.veiculos.Carga;
import exercises.e23.model.veiculos.Ligeiro;
import exercises.e23.model.veiculos.Pesado;
import exercises.e23.model.veiculos.Veiculo;

public class Frota {
    protected HashSet<Veiculo> veiculos;

    public Frota() {
        veiculos = new HashSet<Veiculo>();
    }

    
    public void addVeiculo(String matricula, int ano, int carga, int passageiros){
        if( passageiros != 0 && carga!=0  ){
            Pesado p = new Pesado(matricula, ano);
            veiculos.add(p);

        }else if ( carga == 0 ){
            Ligeiro l = new Ligeiro(matricula, ano);
            veiculos.add(l);
        }else{
            Carga c = new Carga(matricula,ano);
            veiculos.add(c);
        }
    }


    public void removeVeiculo(String matricula){
         for( Veiculo v : veiculos ){
                if( v.getMatricula() == matricula ){
                    veiculos.remove(v);
                }
         }
    }


    public String listaVeiculos(){
        String s = "\n";
        for( Veiculo v : veiculos ){
             s += "[" + v.getMatricula() + "] " + v.getClass().getSimpleName() + "\n";
        }
        return s;
    }


    // veiculos com limite de passageiros 
    // por ondem de passageiros, primeiro os de limite menos 
    public String listaVeiculoslimPassageiros(){ 
        String s = "\n";
          // TODO - ordernar HashSet 

        return s;

    }


    // veiculos com limute de carga 
    // por ordem inversa, primeiro os de limite maior 
    public String listaVeiculoslimCarga(){
        
        // TODO - ordernar HashSet 

        return "";
    }



    
}
