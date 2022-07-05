package exemplos.Elevador_v2021.logica.dados;

import java.util.ArrayList;

public class ElevadorDados {
    private ArrayList<String> historico= new ArrayList<String>();

    public void addPassagem(String s){
        historico.add(s);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String s: historico)
            sb.append(s).append("\n");
        return sb.toString();
    }
}
