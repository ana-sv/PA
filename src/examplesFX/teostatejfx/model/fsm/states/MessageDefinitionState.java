package examplesFX.teostatejfx.model.fsm.states;

import examplesFX.teostatejfx.model.data.ModelData;
import examplesFX.teostatejfx.model.fsm.Context;
import examplesFX.teostatejfx.model.fsm.State;
import examplesFX.teostatejfx.model.fsm.StateAdapter;

public class MessageDefinitionState extends StateAdapter {
    public MessageDefinitionState(Context context, ModelData data) {
        super(context,data);
    }

    @Override
    public void next() {
        changeState(State.NUMBER_DEFINITION);
    }

    @Override
    public void previous() {
        changeState(State.BEGIN);
    }

    @Override
    public void changeMessage(String msg) {
        data.setMessage(msg);
    }

    @Override
    public State getState() {
        return State.MESSAGE_DEFINITION;
    }
}

