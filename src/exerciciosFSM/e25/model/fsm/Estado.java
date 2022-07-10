package exerciciosFSM.e25.model.fsm;

import exerciciosFSM.e25.model.data.Jogo;

public abstract class Estado implements IEstado { // aka adapter
    protected Contexto c;
    protected Jogo d;

    public Estado(Contexto c, Jogo d) {
        this.c = c;
        this.d = d;
    }

    protected void changeState(EstadoEnum novoEstado) {
        c.changeState(novoEstado.createState(c, d));
    }

    @Override
    public void escolheu(TipoPeca p) {
    }

    @Override
    public void escolheu(TipoPeca p, boolean maior) {
    }

}
