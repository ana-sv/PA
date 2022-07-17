package EXAMES.Exame2022.perg_Melga.model.fsm;

import EXAMES.Exame2022.perg_Melga.model.data.MelgaData;

class StatePronta extends MelgaAdapter {

   public StatePronta(MelgaContext context, MelgaData data) {
        super(context, data);
    }

    @Override
    public void descola() {
       //changeState( new StateEmVoo(context, data)); // SEM FACTORY
       changeState(MelgaState.EMVOO);  //COM FACTORY
    }

    @Override
    public void pica() {
        data.incrementaPicada();
        //changeState(new StatePousada(context, data));  // SEM FACTORY 
        changeState(MelgaState.POUSADA);  //COM FACTORY
    }

    @Override
    public MelgaState getState() {
        return MelgaState.PRONTA;
    }
    
}
