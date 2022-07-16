package EXAMES.Exame2022.perg_Melga.model.fsm;

import EXAMES.Exame2022.perg_Melga.model.data.MelgaData;

public enum MelgaState { // 5bi
    EMVOO, POUSADA, PRONTA, MORTA;

    public IStates createState(MelgaContext c, MelgaData d) { // 5c  FACTORY 
        return switch (this) {
            case EMVOO -> new StateEmVoo(c, d);
            case POUSADA -> new StatePousada(c, d);
            case PRONTA -> new StatePronta(c, d);
            case MORTA -> new StateMorta(c, d);
            default -> null;
        };
    }

}
