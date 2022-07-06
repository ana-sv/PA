package exerciciosFSM.e27.model.fsm;

import exerciciosFSM.e27.model.data.GameBWData;

public enum GameBWState {
    STATE_1, STATE_2, STATE_3, STATE_N ; // TODO

    public IGameBWState createState(GameBWContext context, GameBWData data) {
        return switch (this) {

            default -> null;
        };
    }
}
