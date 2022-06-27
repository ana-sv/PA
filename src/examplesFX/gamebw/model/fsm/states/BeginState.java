package examplesFX.gamebw.model.fsm.states;

import examplesFX.gamebw.model.data.GameBWData;
import examplesFX.gamebw.model.fsm.GameBWContext;
import examplesFX.gamebw.model.fsm.GameBWState;
import examplesFX.gamebw.model.fsm.GameBWStateAdapter;

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
