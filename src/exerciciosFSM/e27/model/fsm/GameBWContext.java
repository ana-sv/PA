package exerciciosFSM.e27.model.fsm;

import exerciciosFSM.e27.model.data.GameBWData;

public class GameBWContext {
    // referencia para o estado atual e para o modelo de dados 
    IGameBWState state;
    GameBWData data;

    // construtor, indicando o primeiro estado a lançar
    public GameBWContext() {
        data = new GameBWData();
        state = GameBWState.BEGIN.createState(this,data);
    }

    // método package-private que permite alterar o estado atual 
    void changeState(IGameBWState newState) {
        state = newState;
    }

    // método publico que permite saber o estado atual 
    public GameBWState getState() {
        if (state == null)
            return null;
        return state.getState();
    }

    // métodos que permitem obter os dados necessários ao funcionamento do programa 

    // getters
    public int getNrWhiteBallsWon() {
        return data.getNrWhiteBallsWon();
    }

    public int getNrWhiteBallsOut() {
        return data.getNrWhiteBallsOut();
    }

    public int getNrBlackBallsOut() {
        return data.getNrBlackBallsOut();
    }

    public boolean bagIsEmpty() {
        return data.bagIsEmpty();
    }

    // others
    public void start() {
        state.start();
    }

    public void end() {
        state.end();
    }

    public BetResult bet(int nr_balls) {
        return state.bet(nr_balls);
    }

    public boolean loseWhiteball() {
        return state.loseWhiteball();
    }
    public boolean removeTwoBalls() {
        return state.removeTwoBalls();
    }


}
