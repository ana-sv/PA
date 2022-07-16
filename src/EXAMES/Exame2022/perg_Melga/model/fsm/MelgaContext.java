package EXAMES.Exame2022.perg_Melga.model.fsm;

import EXAMES.Exame2022.perg_Melga.model.data.MelgaData;

public class MelgaContext {
    // referencia para o estado atual e para o modelo de dados 
    private MelgaData data; 
    private IStates state; 

     // construtor, indicando o primeiro estado a lançar
    public MelgaContext(){
        this.data = new MelgaData();
       // this.state = new StateEmVoo(this,data);  // SEM FACTORY
        this.state = MelgaState.EMVOO.createState(this, data); //COM FACTORY 
    }

    // método público que permite saber o estado atual
    public MelgaState getState(){
        return state.getState();
    }

    // método package private que muda o estado atual 
    public void changeState( IStates state ){
        this.state=state; 
    }

    // métodos que reencaminham as acçoes/eventos para os métodos do estado ativo
    public void mexe() {
        state.mexe();
    }

   public  void pica(){
        state.pica();
    }

   public void descola(){
        state.descola();
    }

   public boolean tentaEsmagar(){
        return state.tentaEsmagar();
    }


    // métodos que permitem obter os dados necessários ao funcionamento do programa 
    public long getNumMexidas(){
        return data.getNumMexidas(); 
    }

    public long getNumTentativasEsmagamento(){
        return data.getNumTentativasEsmagamento();
    }

    public long getNumPicadas(){
        return data.getNumPicadas(); 
    }

    public boolean isPousadaEmAnimal(){
        return data.isPousadaEmAnimal();
    }

    public boolean isPousadaEmObjecto(){
        return data.isPousadaEmObjecto();
    }



}
