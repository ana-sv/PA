package exerciciosFX.gamebw.model.fsm;

import exerciciosFX.gamebw.model.data.GameBWData;
import exerciciosFX.gamebw.model.fsm.states.BeginState;
import exerciciosFX.gamebw.model.fsm.states.LostWaitDecisionState;
import exerciciosFX.gamebw.model.fsm.states.WaitBetState;

public enum GameBWState {
    BEGIN, WAIT_BET, LOST_WAIT_DECISION;

    public IGameBWState createState(GameBWContext context, GameBWData data) {
        return switch (this) {
            case BEGIN -> new BeginState(context,data);
            case WAIT_BET -> new WaitBetState(context,data);
            case LOST_WAIT_DECISION -> new LostWaitDecisionState(context,data);
            //default -> null;
        };
    }
}
