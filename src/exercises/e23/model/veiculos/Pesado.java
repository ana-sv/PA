package exercises.e23.model.veiculos;

public class Pesado extends Veiculo {
    private static final int limCarga = 1; // toneladas
    private static final int limPassageiros = 50;
    
    public Pesado(String matricula, int ano) {
        super(matricula, ano);        
    }

    public int getLimPassageiros(){
        return Pesado.limPassageiros; //"should be accessed in a static way"
    }

    public int getLimCarga(){
        return Pesado.limCarga; //"should be accessed in a static way"
    }

    
}
