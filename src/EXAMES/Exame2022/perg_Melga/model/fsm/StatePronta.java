package EXAMES.Exame2022.perg_Melga.model.fsm;

import EXAMES.Exame2022.perg_Melga.model.data.MelgaData;

class StatePronta extends MelgaAdapter {

   public StatePronta(MelgaContext context, MelgaData data) {
        super(context, data);
    }

    @Override
    public void descola() {
       // context.changeState( new StateEmVoo(context, data)); // SEM FACTORY
       context.changeState(MelgaState.EMVOO.createState(context, data));  //COM FACTORY
    }

    @Override
    public void pica() {
        data.incrementaPicada();
        //context.changeState(new StatePousada(context, data));  // SEM FACTORY 
        context.changeState(MelgaState.POUSADA.createState(context, data));  //COM FACTORY
    }

    @Override
    public MelgaState getState() {
        return MelgaState.PRONTA;
    }
    
}
