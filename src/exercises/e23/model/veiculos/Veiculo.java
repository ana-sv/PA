package exercises.e23.model.veiculos;


public abstract class Veiculo {
    protected String matricula; 
    protected int ano; 

    public Veiculo( String matricula, int ano ){
        this.matricula = matricula; 
        this.ano = ano; 
    }


    public int getAno(){
        return this.ano;     
    }

    public String getMatricula(){
        return this.matricula; 
    }

    @Override
    public boolean equals(Object o) {
        if( o == this )
            return true; 

        if( o==null || !(o instanceof Object) )
            return false; 

        Veiculo v = (Veiculo) o; 
        return this.matricula == v.matricula;
    }

 
    
    
}
