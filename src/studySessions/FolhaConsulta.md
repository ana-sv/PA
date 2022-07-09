#### Maquina de Estados

``` java
public enum GameBWState {
    BEGIN, WAIT_BET, LOST_WAIT_DECISION;

    // Factory
    public IGameBWState createState(GameBWContext context, GameBWData data) {
        return switch (this) {
            case BEGIN -> new BeginState(context,data);
            //...
    }}};
``` 

``` java
public interface IGameBWState {
    void start();
    //...
    GameBWState getState();
}
``` 


``` java
public abstract class GameBWStateAdapter implements IGameBWState {
    protected GameBWContext context;
    protected GameBWData data;

    protected GameBWStateAdapter(GameBWContext context, GameBWData data) {
        this.context = context;
        this.data = data;
    }

    protected void changeState(GameBWState newState) {
        context.changeState(newState.createState(context,data));
    }

    @Override
    public void start() {
    //....
}
``` 


``` java
public class GameBWContext {
    IGameBWState state;
    GameBWData data;

    public GameBWContext() {
        data = new GameBWData();
        state = GameBWState.BEGIN.createState(this,data);
    }

    void changeState(IGameBWState newState) {
        state = newState;
    }

    public void start() {
        state.start();
    }

    public GameBWState getState() {
        return state.getState();
    }
``` 

``` java
public class BeginState extends GameBWStateAdapter {
    public BeginState(GameBWContext context, GameBWData data) {
        super(context, data);
    }

    @Override
    public void start() {
        data.initGame();
        changeState(GameBWState.WAIT_BET);
    }

    @Override
    public GameBWState getState() {
        return GameBWState.BEGIN;
    }
}
``` 

``` java
// Ja faz parte do modelo de javaFx
public class GameBWManager {
    private GameBWContext fsm;
    PropertyChangeSupport pcs;

    public GameBWManager() {
        fsm = new GameBWContext();
        pcs = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
    public void start() {
        fsm.start();
        pcs.firePropertyChange(null,null,null);
    }

    public BetResult bet(int nr_balls) {
        var ret = fsm.bet(nr_balls);
        pcs.firePropertyChange(null,null,null);
        return ret;
    }

    public GameBWState getState() {
        return fsm.getState();
    }

    public int getNrWhiteBallsWon() {
        return fsm.getNrWhiteBallsWon();
    }
}
``` 


#### Command e Facade
``` java
public class CommandManager {
    private Deque<ICommand> history;
    private Deque<ICommand> redoCmds;

    public CommandManager() {
        history = new ArrayDeque<>();
        redoCmds = new ArrayDeque<>();
    }

    public boolean invokeCommand(ICommand cmd) {
        redoCmds.clear();
        if (cmd.execute()) {
            history.push(cmd);
            return true;
        }
        history.clear();
        return false;
    }

    public boolean undo() {
        if (history.isEmpty())
            return false;
        ICommand cmd = history.pop();
        cmd.undo();
        redoCmds.push(cmd);
        return true;
    }

    public boolean redo() {
        if (redoCmds.isEmpty())
            return false;
        ICommand cmd = redoCmds.pop();
        cmd.execute();
        history.push(cmd);
        return true;
    }

    public boolean hasUndo() {
        return history.size() > 0;
    }

    public boolean hasRedo() {
        return redoCmds.size() > 0;
    }
}
``` 



``` java
public interface ICommand {
    boolean execute();
    boolean undo();
    }
```



``` java
public abstract class CommandAdapter implements ICommand {  
    // só é public porque eu tenho em package diferente que os concrete commands
    protected ShoppingList receiver; // ReciverClass

    protected CommandAdapter(ShoppingList receiver) {
        this.receiver = receiver;
    }
}
``` 



``` java
// concrete command 
public class AddProduct extends CommandAdapter {
    private String nomeProduto;
    private double quantidade;

    public AddProduct(ShoppingList receiver, String s, double d) {
        super(receiver);
        this.nomeProduto = s;
        this.quantidade = d;
    }

    @Override
    public boolean execute() {
        return receiver.addProduct(nomeProduto, quantidade);
    }

    @Override
    public boolean undo() {
        return receiver.removeProduct(nomeProduto, quantidade);
    }
}
``` 



``` java
//Reciver Manager , Facade
public class ShoppingListManager {

    ShoppingList rc; // data
    CommandManager cm;

    public ShoppingListManager() {
        rc = new ShoppingList();
        cm = new CommandManager();
    }

    // public boolean concreteCommand1(<parameters>) {
    // return cm.invokeCommand(new ConcreteCommand1(rc,<parameters>)); }

  public boolean  addProduct(String readString, double readNumber) {
        return cm.invokeCommand(new AddProduct(rc, readString, readNumber));
    }

    public boolean removeProduct(String readString, double readNumber) {
        return cm.invokeCommand(new RemoveProduct(rc, readString, readNumber));
    }
    
    public boolean hasUndo() {
        return cm.hasUndo();
    }

    public boolean undo() {
        return cm.undo();
    }

    public boolean hasRedo() {
        return cm.hasRedo();
    }

    public boolean redo() {
        return cm.redo();
    }
    // ...
}
``` 

#### Serialização e Decorator

``` java

``` 



``` java

``` 



``` java

``` 



``` java

``` 



``` java

``` 



``` java

``` 
