package exemplosFX.teostatejfx.model.fsm.states;

import exemplosFX.teostatejfx.model.data.ModelData;
import exemplosFX.teostatejfx.model.fsm.Context;
import exemplosFX.teostatejfx.model.fsm.State;
import exemplosFX.teostatejfx.model.fsm.StateAdapter;

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
