package exercises.e16;

import java.util.HashMap;
import java.util.Map.Entry;

public class Turma implements ITurma {

    protected HashMap<Integer, Aluno> alunos;

    public Turma() {
        alunos = new HashMap<Integer, Aluno>();
    }

    @Override
    public void addAluno(String nome, int numero) {
        Aluno novoAluno = new Aluno(nome);
        if (!alunos.containsKey(numero)) {
            alunos.put(numero, novoAluno);
        }
    }

    public int findByName(String name) {
        for (Entry<Integer, Aluno> entry : alunos.entrySet()) {
            if (entry.getValue().getNome() == name)
                return entry.getKey();
        }

        return 0;
    }

    @Override
    public void addNota(String nome, float nota) {
        int key = findByName(nome);
        if (  key  != 0 ){
            alunos.get(key).getArrayNotas().add(nota);
        }
    }


    @Override
    public void addNota(int numero, float nota) {
        if (alunos.containsKey(numero))
            alunos.get(numero).getArrayNotas().add(nota);

    }

    @Override
    public String getNotaTeste(int numero, int index) {
        if (alunos.containsKey(numero))
            return alunos.get(numero).getArrayNotas().get(index-1).toString();
        return null;
    }

    @Override
    public String getNotaTeste(String nome, int index) {
        int key = findByName(nome);
        if (  key  != 0 ){
            return alunos.get(key).getArrayNotas().get(index-1).toString();
        }

        return null;
    }

}
