package exercises.e16;

public interface ITurma {

    public void addAluno( String nome, int num );
    public void addNota( String nome, int nota);
    public void addNota( int num, int nota );
    public String getNotaTeste( String nome, int index);
    public String getNotaTeste( int num, int index); 
    
}
