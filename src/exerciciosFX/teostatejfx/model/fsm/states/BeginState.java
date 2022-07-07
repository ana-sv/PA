package exerciciosFX.teostatejfx.model.fsm.states;

import exerciciosFX.teostatejfx.model.data.ModelData;
import exerciciosFX.teostatejfx.model.fsm.Context;
import exerciciosFX.teostatejfx.model.fsm.State;
import exerciciosFX.teostatejfx.model.fsm.StateAdapter;

public class BeginState extends StateAdapter {
    public BeginState(Context context, ModelData data) {
        super(context,data);
    }

    @Override
    public void next() {
        changeState(State.MESSAGE_DEFINITION);
    }

    @Override
    public State getState() {
        return State.BEGIN;
    }
}
