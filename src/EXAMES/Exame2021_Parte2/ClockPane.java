package EXAMES.Exame2021_Parte2;

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

    }

    private void update(){
     //   ESituation situation = obs.getSituation();
        // Definir o texto da label display
        // C 

        //Definir o estado de ativacao ( disable/enable) dos botoes set, inc e dec
        // D

    }


    


}