package exerciciosFSM.e24.model.data;

import java.util.ArrayList;

public class ElevatorData {

    private ArrayList<String> history= new ArrayList<String>();

    public void addINFO(String s){
        history.add(s);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String s: history)
            sb.append(s).append("\n");
        return sb.toString();
    }
}

    
