package EXAMES.Exame2022.perg_Melga.model.fsm;

public interface IStates {  // 5.b.ii

    Object EMVOO = null;

    // métodos que representam mudanças de estado 
    boolean tentaEsmagar();
    void mexe();
    void pica();
    void descola(); 
    
    // método getState 
    MelgaState getState();  
    

}
