package EXAMES.Exame2022.perg_Melga.model.fsm;

import EXAMES.Exame2022.perg_Melga.model.data.MelgaData;

 class StatePousada extends MelgaAdapter {

    public StatePousada(MelgaContext context, MelgaData data) {
        super(context, data);
    }

    @Override
    public void descola() {
      //changeState(new StateEmVoo(context, data)); // SEM FACTORY
      changeState(MelgaState.EMVOO);  //COM FACTORY
    }

    @Override
    public MelgaState getState() {
        return MelgaState.POUSADA;
    }
    
}
