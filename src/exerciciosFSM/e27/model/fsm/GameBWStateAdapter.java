package exerciciosFSM.e27.model.fsm;

import exerciciosFSM.e27.model.data.GameBWData;

abstract class GameBWStateAdapter implements IGameBWState {
    GameBWContext context;
    GameBWData data;

    protected GameBWStateAdapter(GameBWContext context, GameBWData data) {
        this.context = context;
        this.data = data;
    }

    protected void changeState(GameBWState newState) {
        context.changeState(newState.createState(context,data));
    }

}
