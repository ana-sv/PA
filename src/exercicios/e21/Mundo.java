package exercicios.e21;

import java.util.ArrayList;
import java.util.HashMap;

public class Mundo {

    protected HashMap<Posicao,ArrayList<Pessoa>> area; 
    protected int tempoImunindade; 
    protected int tempoInfecao; 

    public Mundo(int imunidade, int infecao ){
        this.tempoImunindade = imunidade;
        this.tempoInfecao = infecao; 
        area = new HashMap<Posicao,ArrayList<Pessoa>>();
    }

    public void addPessoaIdosa( int x , int y , String nome){
        Posicao posicao = new Posicao(x, y);
        Idoso idoso = new Idoso(nome);
        if( !area.containsKey(posicao) ){
            area.put(posicao, new ArrayList<Pessoa>());
            area.get(posicao).add(idoso);
        }
        area.get(posicao).add(idoso);
    }

    public void addPessoaJovem( int x , int y , String nome){
        Posicao posicao = new Posicao(x, y);
        Jovem jovem = new Jovem(nome);
        if( !area.containsKey(posicao) ){
            area.put(posicao, new ArrayList<Pessoa>());
            area.get(posicao).add(jovem);
        }
        area.get(posicao).add(jovem);
    }




    
}
