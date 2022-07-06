package exerciciosFSM.e27.model.fsm.states;

import exerciciosFSM.e27.model.data.BallType;
import exerciciosFSM.e27.model.data.GameBWData;
import exerciciosFSM.e27.model.fsm.BetResult;
import exerciciosFSM.e27.model.fsm.GameBWContext;
import exerciciosFSM.e27.model.fsm.GameBWState;
import exerciciosFSM.e27.model.fsm.GameBWStateAdapter;

public class WaitBetState extends GameBWStateAdapter {

    public WaitBetState(GameBWContext context, GameBWData data) {
        super(context, data);
    }

    @Override
    public BetResult bet(int nr_balls) {
        if (!data.bet(nr_balls))
            return BetResult.ERROR;

        BallType ball = data.getBall();
        switch (ball) {
            case WHITE -> {
                data.betWon();
                changeState(data.bagIsEmpty() ? GameBWState.BEGIN : GameBWState.WAIT_BET);
                return BetResult.WON;
            }
            case BLACK -> {
                data.betLost();
                changeState(data.bagIsEmpty() && data.getNrWhiteBallsWon()<1 ? GameBWState.BEGIN : GameBWState.LOST_WAIT_DECISION);
                return BetResult.LOST;
            }
            case NONE -> changeState(GameBWState.BEGIN);
        }
        return BetResult.ERROR;
    }

    @Override
    public void end() {
        changeState(GameBWState.BEGIN);
    }

    @Override
    public GameBWState getState() {
        return GameBWState.WAIT_BET;
    }
}
