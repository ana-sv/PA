package exercicios.e23.model.veiculos;

public class Carga extends Veiculo{
   private static final int limCarga = 43;  //toneladas


    public Carga(String matricula, int ano ) {
        super(matricula, ano);        
    }

    public int getLimCarga(){
        return Carga.limCarga; //"should be accessed in a static way"
    }


    
}
