package examplesFX.teostatejfx.model.fsm.states;

import examplesFX.teostatejfx.model.data.ModelData;
import examplesFX.teostatejfx.model.fsm.Context;
import examplesFX.teostatejfx.model.fsm.State;
import examplesFX.teostatejfx.model.fsm.StateAdapter;

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
