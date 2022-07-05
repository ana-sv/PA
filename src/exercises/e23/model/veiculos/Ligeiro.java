package exercises.e23.model.veiculos;

public class Ligeiro extends Veiculo  {
    private static final int limPassageiros = 9;
    
    public Ligeiro(String matricula, int ano) {
        super(matricula, ano);        
    }

    public int getLimPassageiros(){
        return Ligeiro.limPassageiros; //"should be accessed in a static way"
    }



}
