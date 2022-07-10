package EXAMES.Exame2021.BasicClock.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import EXAMES.Exame2021.BasicClock.model.fsm.Context;
import EXAMES.Exame2021.BasicClock.model.fsm.State;


public class ObservableBasicClock {
    public static final String UPDATE_PROPERTY = "update";
    //private BasicClock basicClock;  //mudei nome só para dar com o exercicio anterior
    private Context basicClock;
    PropertyChangeSupport pCSupport;

    public ObservableBasicClock(int h, int m, int s) {
      //  basicClock = new BasicClock(h, m, s);
        basicClock = new Context(h,m,s);
        pCSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(String property, PropertyChangeListener listener) {
        pCSupport.addPropertyChangeListener(property, listener);
    }

    // para a alinea seguinte 
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pCSupport.addPropertyChangeListener(listener);
    }

    public int getH() {
        return basicClock.getH();
    }

    public int getM() {
        return basicClock.getM();
    }

    public int getS() {
        return basicClock.getS();
    }

    //public ESituation getSituation() {
    public State getState(){
       // return basicClock.getSituation();
       return basicClock.getState();
    }

    // faltavam os "pCSupport.firePropertyChange(" ????
    // de cada vez que se alteram dados tem que se fazer o firePropertyChange (???)
    public void onOff() {
        basicClock.onOff();
        pCSupport.firePropertyChange(null, null,null);

    }

    public void set() {
        basicClock.set();
        pCSupport.firePropertyChange(null, null,null);

    }

    public void increment() {
        basicClock.increment();
        pCSupport.firePropertyChange(null, null,null);

    }

    public void decrement() {
        basicClock.decrement();
        pCSupport.firePropertyChange(null, null,null);
    }

    @Override
    public String toString() {
        return basicClock.toString();
    }




}
