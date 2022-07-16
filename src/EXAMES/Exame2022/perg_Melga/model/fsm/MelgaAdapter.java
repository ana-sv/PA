package EXAMES.Exame2022.perg_Melga.model.fsm;

import java.util.Random;

import EXAMES.Exame2022.perg_Melga.model.data.MelgaData;

class MelgaAdapter implements IStates {
    // referencias para data e context com etiqueta protected
    protected MelgaData data;
    protected MelgaContext context;

    protected MelgaAdapter(MelgaContext context, MelgaData data) {
        this.data = data;
        this.context = context;
    }

    // metodo changeState protected SEM FACTORY
    protected void changeState(IStates newState) {
        context.changeState(newState);
    }

    // metodo changeState protected COM FACTORY
    // protected void changeState( IStates newStates){
    // context.changeState(newStates.createState(context, data)); }

    // método comum a todos os estados
    @Override
    public boolean tentaEsmagar() {

        if (context.getState() != MelgaState.MORTA) {
            data.incrementaTentativas();
            Random rdn = new Random();
            if (rdn.nextInt(100) < 20) { // esmaga 20% das x

                //context.changeState(new StateMorta(context, data)); // SEM FACTORY
                MelgaState.MORTA.createState(context, data);  // COM FACTORY
                return true;
            } else {
              //  context.changeState(new StateEmVoo(context, data));
                  MelgaState.EMVOO.createState(context, data); // COM FACTORY 
                return false;
            }

        }
        return false;
    }

    @Override
    public void mexe() {
    };

    @Override
    public void pica() {
    };

    @Override
    public void descola() {
    }

    @Override
    public MelgaState getState() {
        return null;
    };

}
