package exerciciosFX.gamebw.model.fsm.states;

import exerciciosFX.gamebw.model.data.GameBWData;
import exerciciosFX.gamebw.model.fsm.GameBWContext;
import exerciciosFX.gamebw.model.fsm.GameBWState;
import exerciciosFX.gamebw.model.fsm.GameBWStateAdapter;

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
