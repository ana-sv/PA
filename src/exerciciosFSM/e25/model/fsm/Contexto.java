package exerciciosFSM.e25.model.fsm;

import exerciciosFSM.e25.model.data.Jogo;

public class Contexto {
    IEstado estado;
    Jogo data;

    public Contexto( ){
        data = new Jogo();
        estado = EstadoEnum.INICIO.createState(this,data);
    }
    
    void changeState(IEstado novoEstado) {
        this.estado = novoEstado; 
    }

    public EstadoEnum getState(){
        return estado.getState();
    }


    
}
