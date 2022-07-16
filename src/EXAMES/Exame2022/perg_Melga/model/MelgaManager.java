package EXAMES.Exame2022.perg_Melga.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import EXAMES.Exame2022.perg_Melga.model.fsm.MelgaContext;
import EXAMES.Exame2022.perg_Melga.model.fsm.MelgaState;

public class MelgaManager {
    private MelgaContext melgaFsm; 
    private PropertyChangeSupport pcs; 

    public MelgaManager(){
        melgaFsm  = new MelgaContext();
        pcs = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        pcs.addPropertyChangeListener(listener);
    }

    public void mexe(){
        melgaFsm.mexe();
        pcs.firePropertyChange(null, null, null);
    }

    public boolean tentaEsmagar(){
       boolean result =  melgaFsm.tentaEsmagar();
        pcs.firePropertyChange(null, null, null);
        return result;
    }

    public MelgaState getState(){
        return  melgaFsm.getState();
    }

    public long getNumMexidas(){ 
        return  melgaFsm.getNumMexidas();
    }

    public long getTentatidasEsmagamento(){ 
       return  melgaFsm.getNumTentativasEsmagamento();
    }

    public long getNumPicadas(){
        return melgaFsm.getNumPicadas();

    }

    public boolean isPousadasEmAnimal(){ 
        boolean a =  melgaFsm.isPousadaEmAnimal();
        pcs.firePropertyChange(null, null, null);
        return a; 
    }

    public boolean isPousadaEmObjeto(){
        boolean o = melgaFsm.isPousadaEmObjecto(); 
        pcs.firePropertyChange(null, null, null);
        return o; 
    }
    
    
}
