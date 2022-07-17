package EXAMES.Exame2022.perg_Melga.model.fsm;

import EXAMES.Exame2022.perg_Melga.model.data.MelgaData;

 class StateEmVoo extends MelgaAdapter {

    public StateEmVoo(MelgaContext context, MelgaData data) {
        super(context, data);
    }

    @Override
    public MelgaState getState() {
        return MelgaState.EMVOO; 
    }


    @Override
    public void mexe() {
        data.incrementaMexidas();
        if( data.isPousadaEmAnimal() == true  )
            //changeState( new StatePronta(context,data)); // SEM FACTORY 
           changeState( MelgaState.PRONTA) ;  //COM FACTORY
        else 
          //changeState( new StatePousada(context,data) ); // SEM FACTORY 
          changeState( MelgaState.POUSADA ); //COM FACTORY
    }

    
}
