## Padrão Command 
> - Este padão encapsula os comandos a serem executados sobre um determinado alvo ( receptor/ facade ); 
>  - Define as operações a serem executadas quando é invocado um comando através do gestor de comandos - Deste modo é possivel fazer **undo** e **redo** ! :) 


### ICommand 
> Interface básica com os métodos package-private execute e undo 
```java

public interface ICommand {
    boolean execute();
    boolean undo();
    }
```

### Adapter 
> esta classe é opcional, implementa IComand , permitindo disponibilizar implementações comuns para os diversos comandos; Tem referência para a class reciver
```java

abstract class CommandAdapter implements ICommand {
    protected ReceiverClass receiver;

    protected CommandAdapter(ReceiverClass receiver) {
        this.receiver = receiver;
    }
}
```

### ConcreteCommand 
> comando concreto a ser utilizado 
```java
// exemplo de um comando usado o exercicio ShoppingList
public class AddProduct extends CommandAdapter {
    private String nomeProduto;
    private double quantidade;

    public AddProduct(ShoppingList receiver, String s, double d) {
        super(receiver); this.nomeProduto = s; this.quantidade = d;   }

    @Override
    public boolean execute() { return receiver.addProduct(nomeProduto, quantidade); }

    @Override
    public boolean undo() { return receiver.removeProduct(nomeProduto, quantidade); }
}


// template
public class ConcreteCommand extends CommandAdapter {
    private <variables needed to execute this command>

    public ConcreteCommand(ReceiverClass receiver, <additional parameters>) {
        super(receiver); <store parameters> } 
        
    @Override
    public boolean execute() { return receiver.concreteCommand(<parameters>); } 
    
    @Override
    public boolean undo() { return receiver.undoConcreteCommand(<parameters>); }
}


```

### CommandManger 
> responsável pela execução do comando invocado e pela gestão do histórico de comandos para possibilitar acções de undo e redo ; É SEMPRE IGUAL 
```java
public class CommandManager {
    private Deque<ICommand> history;
    private Deque<ICommand> redoCmds;

    // private Stack<ICommand> history;
    // private Stack<ICommand> redoCmds;
    public CommandManager() {
        history = new ArrayDeque<>();
        redoCmds = new ArrayDeque<>();
        // history = new Stack<>();
        // redoCmds = new Stack<>();
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

### ReciverManager 
> OU FACADE : deverá fornecer métodos simples que permitam redirecionar para os objectos internos dos packages 
> em algumas aplicaçºoes as classes facade podem ser implementadas segundo o padrão **Singleton**
```java
// template 
public class ReceiveManager { 
    ReceiverClass rc;
    CommandManager cm;

    public ReceiveManager() {
        rc = new ReceiverClass();
        cm = new CommandManager();
    }

    public boolean concreteCommand1(<parameters>) {
    return cm.invokeCommand(new ConcreteCommand1(rc,<parameters>));
    }

    public boolean concreteCommand2(<parameters>) {
    return cm.invokeCommand(new ConcreteCommand2(rc,<parameters>));
    }

    // ...
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

### Reciver 
> classe responsável por guardar os dados aplicação e que implementa os métodos necessários ao funcionamento dos comandos e também do resto a aplicação
```java
// exemplo da classe reciver do exercicio ShoppingList
public class ShoppingList {
    private ArrayList<Product> list;

    public ShoppingList() {
        list = new ArrayList<>();
    }

    public boolean addProduct(String name, double qt) {
        if (name != null && !name.isBlank() && qt > 0) {
            list.add(new Product(name, qt));
            return true;
        }
        return false;
    }

    public boolean removeProduct(String name, double qt) {
        return list.remove(new Product(name, qt));
    }
    //...
```
