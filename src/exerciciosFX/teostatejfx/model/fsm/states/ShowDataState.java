package exerciciosFX.teostatejfx.model.fsm.states;

import exerciciosFX.teostatejfx.model.data.ModelData;
import exerciciosFX.teostatejfx.model.fsm.Context;
import exerciciosFX.teostatejfx.model.fsm.State;
import exerciciosFX.teostatejfx.model.fsm.StateAdapter;

public class ShowDataState extends StateAdapter {
    public ShowDataState(Context context, ModelData data) {
        super(context, data);
    }

    @Override
    public void previous() {
        changeState(State.NUMBER_DEFINITION);
    }

    @Override
    public State getState() {
        return State.SHOW_DATA;
    }
}
