package exerciciosFSM.e27.model.fsm.states;

import exerciciosFSM.e27.model.data.GameBWData;
import exerciciosFSM.e27.model.fsm.GameBWContext;
import exerciciosFSM.e27.model.fsm.GameBWState;
import exerciciosFSM.e27.model.fsm.GameBWStateAdapter;

public class BeginState extends GameBWStateAdapter {

    public BeginState(GameBWContext context, GameBWData data) {
        super(context, data);
    }

    @Override
    public void start() {
        data.initGame();
        changeState(GameBWState.WAIT_BET);
    }

    @Override
    public GameBWState getState() {
        return GameBWState.BEGIN;
    }
}
