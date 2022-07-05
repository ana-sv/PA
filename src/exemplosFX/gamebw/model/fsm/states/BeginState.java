package exemplosFX.gamebw.model.fsm.states;

import exemplosFX.gamebw.model.data.GameBWData;
import exemplosFX.gamebw.model.fsm.GameBWContext;
import exemplosFX.gamebw.model.fsm.GameBWState;
import exemplosFX.gamebw.model.fsm.GameBWStateAdapter;

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
