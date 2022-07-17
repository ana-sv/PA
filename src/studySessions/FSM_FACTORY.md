## Padrão Máquina de Estados & Factory


### IState.java 
 > Interface que tem os métodos que representam mudança de estados, métodos package-private, sem etiqueta;
  ```java
      // incluir também o método:
      State getState();  
 ```
#

 ### State.java  
 > enumeração que permite identificar cada estado;
 ```java
  // Usando o padrão FACTORY inclui-se o método: 
  public IStates createState(MelgaContext c, MelgaData d) { 
        return switch (this) {
            case EMVOO -> new StateEmVoo(c, d); /**/ }; }
 ```
#

 ### Adapter.java
 > Implementa interface IState; contém referências para **Context** e **Data** (protected)
  ```java
 // incluir o método: 
    protected void changeState(IStates newState) {
        context.changeState(newState); }

 // e se tiver usado o padrão FACTORY incluir então: 
    protected void changeState( MelgaState newStates){
        context.changeState(newStates.createState(context, data)); }

 ```

#
### Estados: 
 > ex: BeginState.java -> cada estado é uma classe derivada de **Adapter** 
 ```java
    // incluir também o método : 
    @Override
    public State getState() {
        return State.EMVOO; 
    }


    // nota que para mudança para estado seguinte, sem FACTORY usamos 
    changeState(new EmVoo(context, data)); 

    // com FACTORY usamos
    changeState(State.EMVOO);

 ````

#

### Context 
> contém referências package-private de  **IState** e **Data** 
 ```java
// inclui método package-private que muda o estado atual
void changeState( IState newState ){ state = newState; }

// inclui método público que permite saber o estado atual
public State getState(){ return state.getState(); }
 ```
 > contém métodos que reencaminham para as acções/eventos para os métodos do estado ativo 

 > contém conjunto de métodos que permintem obter dados necessários ao funcionamento do programa


!!!  Nota: Não deve disponibilizar métodos que retornam referências que permitam a alteração direta de dados 

