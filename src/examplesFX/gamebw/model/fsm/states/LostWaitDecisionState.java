package examplesFX.gamebw.model.fsm.states;

import examplesFX.gamebw.model.data.GameBWData;
import examplesFX.gamebw.model.fsm.GameBWContext;
import examplesFX.gamebw.model.fsm.GameBWState;
import examplesFX.gamebw.model.fsm.GameBWStateAdapter;

public class LostWaitDecisionState extends GameBWStateAdapter {
    public LostWaitDecisionState(GameBWContext context, GameBWData data) {
        super(context, data);
    }

    @Override
    public boolean loseWhiteball() {
        if (data.betLost_optionWhite()) {
            changeState(data.bagIsEmpty() ? GameBWState.BEGIN : GameBWState.WAIT_BET);
            return true;
        }
        if (data.bagIsEmpty())
            changeState(GameBWState.BEGIN); // not needed but...!
        return false;
    }

    @Override
    public boolean removeTwoBalls() {
        if (data.bagIsEmpty() && data.getNrWhiteBallsWon()>0)
            return false;
        data.betLost_optionTwoBalls();
        changeState(data.bagIsEmpty() ? GameBWState.BEGIN : GameBWState.WAIT_BET);
        return true;
    }

    @Override
    public GameBWState getState() {
        return GameBWState.LOST_WAIT_DECISION;
    }
}
