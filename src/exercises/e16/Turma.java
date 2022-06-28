package exercises.e16;

import java.util.ArrayList;
import java.util.HashMap;

public class Turma implements ITurma {
    protected HashMap<Integer, HashMap<String, ArrayList<Integer>> > alunos; 

    public Turma() {


    }

        // https://stackoverflow.com/questions/2774608/how-do-i-access-nested-hashmaps-in-java


    @Override
    public void addAluno(String nome, int num) {
     
        
    }

    @Override
    public void addNota(String nome, int nota) {
        // TO DO Auto-generated method stub
        
    }

    @Override
    public void addNota(int num, int nota) {
        // TO DO Auto-generated method stub
        
    }

    @Override
    public String getNotaTeste(String nome, int index) {
        // TO DO Auto-generated method stub
        return null;
    }

    @Override
    public String getNotaTeste(int num, int index) {
        // TO DO Auto-generated method stub
        return null;
    }
    
}
