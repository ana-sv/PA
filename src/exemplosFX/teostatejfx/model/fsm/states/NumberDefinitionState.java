package exemplosFX.teostatejfx.model.fsm.states;

import exemplosFX.teostatejfx.model.data.ModelData;
import exemplosFX.teostatejfx.model.fsm.Context;
import exemplosFX.teostatejfx.model.fsm.State;
import exemplosFX.teostatejfx.model.fsm.StateAdapter;

public class NumberDefinitionState extends StateAdapter {
    public NumberDefinitionState(Context context, ModelData data) {
        super(context, data);
    }

    @Override
    public void next() {
        changeState(State.SHOW_DATA);
    }

    @Override
    public void previous() {
        changeState(State.MESSAGE_DEFINITION);
    }

    @Override
    public void changeNumber(int nr) {
        data.setNumber(nr);
    }

    @Override
    public State getState() {
        return State.NUMBER_DEFINITION;
    }
}
