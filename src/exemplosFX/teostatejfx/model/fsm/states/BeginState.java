package exemplosFX.teostatejfx.model.fsm.states;

import exemplosFX.teostatejfx.model.data.ModelData;
import exemplosFX.teostatejfx.model.fsm.Context;
import exemplosFX.teostatejfx.model.fsm.State;
import exemplosFX.teostatejfx.model.fsm.StateAdapter;

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
