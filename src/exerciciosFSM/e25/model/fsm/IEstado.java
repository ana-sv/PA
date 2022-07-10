package exerciciosFSM.e25.model.fsm;

public interface IEstado { 
    void escolheu( TipoPeca p);
    void escolheu(TipoPeca p, boolean maior);
    EstadoEnum getState();
    
}

