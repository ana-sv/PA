package EXAMES.Exame2021.BasicClock.ui.gui.javafx;

import EXAMES.Exame2021.BasicClock.model.ObservableBasicClock;
import EXAMES.Exame2021.BasicClock.model.fsm.State;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ClockPane extends BorderPane{
    private ObservableBasicClock obs; 

    private Label display;
    private Button onOff, set, inc, dec;
    
    public ClockPane(ObservableBasicClock obs){
        // Registar um property change listener em obs e cujo metodo 
        // propertyChange() invoque apenas o metodo update
        // A
        this.obs = obs; 
        obs.addPropertyChangeListener( evt -> { update(); });


        
         display = new Label();

         onOff = new Button("on/off");
         set = new Button("set");
         inc = new Button("+");
         dec = new Button("-");

         arrangeComponents();
         setEventHandlers();
         update();
    }


    private void arrangeComponents(){
        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(onOff,set,inc,dec);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(display,vBox);

        setCenter(vBox);
    }

    private void setEventHandlers(){
        // Definir a resposta a acaoes dos botoes onOff , set inc e dec 
        // B
        onOff.setOnAction( evt -> {
            obs.onOff();
        });
        set.setOnAction( evt -> {
            obs.set();
        });
        inc.setOnAction(evt -> {
            obs.increment();
        });
        dec.setOnAction(evt -> {
            obs.decrement();
        });

    }

    private void update(){
     //  ESituation situation = obs.getSituation();
        State state = obs.getState();  // mudei só para dar com as alineas anteriores
       
       
        // Definir o texto da label display
        // C 
        display.setText(state.toString());


        //Definir o estado de ativacao ( disable/enable) dos botoes set, inc e dec
        // D
        if (state == State.DISPLAY || state == state.DESLIGADO){
            inc.isDisabled(); // or inc.setDisable(true);
            dec.isDisabled(); 
            set.isDisabled();           
        }else if (state == State.DISPLAY){
            inc.isDisabled(); // or inc.setDisable(true);
            dec.isDisabled(); 
        }

    }


    


}