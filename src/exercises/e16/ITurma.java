package exercises.e16;

public interface ITurma {
    public void addAluno(String nome, int numero);

    public void addNota(String nome, float nota);

    public void addNota(int numero, float nota);

    public String getNotaTeste(int numero, int index);

    public String getNotaTeste(String nome, int index);

}
