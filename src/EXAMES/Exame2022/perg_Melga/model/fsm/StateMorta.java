package EXAMES.Exame2022.perg_Melga.model.fsm;

import EXAMES.Exame2022.perg_Melga.model.data.MelgaData;

 class StateMorta extends MelgaAdapter {

    public StateMorta(MelgaContext context, MelgaData data) {
        super(context, data);
    }

    @Override
    public MelgaState getState() {
        return MelgaState.MORTA; 
    }
    
}
