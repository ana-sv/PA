package exercises.e16;

import java.util.ArrayList;

public class Aluno {
    protected String nome;
    protected ArrayList<Float> notas; 

    public Aluno(String nome) {
        this.nome = nome;
        notas = new ArrayList<Float>(); 
    }

    public String getNome() {
        return this.nome;
    }

    public ArrayList<Float> getArrayNotas(){
        return this.notas; 
    }

    public void addNota( float nota ){
        this.notas.add(nota); 
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Aluno a = (Aluno) o;
        if (this.nome == a.nome )
            return true;

        return false;
    }




}
