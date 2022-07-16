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

    public MelgaState geState(){
        MelgaState ms =  melgaFsm.getState();
        pcs.firePropertyChange(null, null, null);
        return ms; 
    }

    public long getNumMexidas(){ 
        long  m = melgaFsm.getNumMexidas();
        pcs.firePropertyChange(null, null, null);
        return m;
    }

    public long getTentatidasEsmagamento(){ 
        long  es = melgaFsm.getNumTentativasEsmagamento();
        pcs.firePropertyChange(null, null, null);
        return es;
    }

    public long getNumPicadas(){
        long p = melgaFsm.getNumPicadas();
        pcs.firePropertyChange(null, null, null);
        return p;
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
