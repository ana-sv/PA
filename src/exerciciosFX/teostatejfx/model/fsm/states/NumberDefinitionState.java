package exerciciosFX.teostatejfx.model.fsm.states;

import exerciciosFX.teostatejfx.model.data.ModelData;
import exerciciosFX.teostatejfx.model.fsm.Context;
import exerciciosFX.teostatejfx.model.fsm.State;
import exerciciosFX.teostatejfx.model.fsm.StateAdapter;

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
