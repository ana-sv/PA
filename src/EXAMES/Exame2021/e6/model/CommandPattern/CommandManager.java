package EXAMES.Exame2021.e6.model.CommandPattern;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandManager {
    private Deque<ICommand> history;

    public CommandManager() {
        this.history =  new ArrayDeque<>();
    }

    public boolean invokeCommand(ICommand cmd) {
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
        return true;
    }

    public boolean hasUndo() {
        return history.size() > 0;
    }

}
