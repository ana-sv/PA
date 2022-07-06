package exerciciosFSM.e27.model.fsm;

import exerciciosFSM.e27.model.data.GameBWData;

public class GameBWContext {
    IGameBWState state;
    GameBWData data;

    public GameBWContext() {
        data = new GameBWData();
        state = GameBWState.STATE_1.createState(this,data);
    }

    void changeState(IGameBWState newState) {
        state = newState;
    }

    // getters
    public GameBWState getState() {
        if (state == null)
            return null;
        return state.getState();
    }

    public int getNrWhiteBallsWon() {
        return data.getNrWhiteBallsWon();
    }

    public int getNrWhiteBallsOut() {
        return data.getNrWhiteBallsOut();
    }

    public int getNrBlackBallsOut() {
        return data.getNrBlackBallsOut();
    }

    public boolean bagIsEmpty() {
        return data.bagIsEmpty();
    }

}
