package examplesFX.teostatejfx.model.fsm.states;

import examplesFX.teostatejfx.model.data.ModelData;
import examplesFX.teostatejfx.model.fsm.Context;
import examplesFX.teostatejfx.model.fsm.State;
import examplesFX.teostatejfx.model.fsm.StateAdapter;

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
