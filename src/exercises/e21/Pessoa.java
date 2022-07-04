package exercises.e21;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Pessoa {
    protected String nome; 
    protected boolean imune; 
    protected Posicao posicao;

    protected Pessoa(String nome ){
        this.nome = nome;
        this.imune = false; 
    }

    public void setPosicao( int x, int y){
        this.posicao = new Posicao(x, y);
    }

    public Posicao getPosicao(){
        return this.posicao;
    }

    public void novaPosicao( ){

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int p= ThreadLocalRandom.current().nextInt(1, 2 + 1);
        switch(p){
            case 1 : this.setPosicao( posicao.x +1 , posicao.y );
            case 2 : this.setPosicao( posicao.x -1 , posicao.y );
            case 3 : this.setPosicao( posicao.x , posicao.y +1 );
            case 4 : this.setPosicao( posicao.x , posicao.y-1 );
        }
    
    }

    
}
