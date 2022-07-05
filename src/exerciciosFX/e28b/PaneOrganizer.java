package exerciciosFX.e28b;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
 
public class PaneOrganizer extends BorderPane {
 
    Button btnVerde, btnAzul;
    Label lblVerde, lblAzul;
    int numerVerde, numeroAzul;

    int numerOutraCor;
    Label lblCor;

    Button btnCor;
    TextField tfCor;
 
    public PaneOrganizer() {
        createPane();
        registerListener();
        numerVerde=0;
        numeroAzul=0;
        numerOutraCor=0;
    }
 
    void createPane() {
        btnVerde = new Button("Green");
        btnVerde.setTextFill(Color.GREEN);
        btnAzul = new Button("Blue");
        btnAzul.setTextFill(Color.BLUE);

        btnCor = new Button("Set Color");
        tfCor = new TextField();

        //numeros dinamicos
        lblVerde = new Label("#Verde: 0");
        lblAzul = new Label("#Azul: 0");
        lblCor = new Label("#Outra Cor: 0");

        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnVerde, btnAzul, tfCor, btnCor);
        hbox.setSpacing(25);
        hbox.setPadding(new Insets(10));
        hbox.setAlignment(Pos.CENTER);
        this.setTop(hbox);



         
        //numeros dinamicos
        HBox hboxlbl = new HBox();
        hboxlbl.getChildren().addAll(lblVerde, lblAzul, lblCor);
        hboxlbl.setSpacing(25);
        hboxlbl.setPadding(new Insets(10));
        hboxlbl.setAlignment(Pos.CENTER);
        hboxlbl.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY)));
        this.setBottom(hboxlbl);


        

         
    }

     
    //dinamicos
    void registerListener() {


        btnCor.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println(" Oi botão " + tfCor.getText() );
              
                PaneOrganizer.this.setBackground(new Background(new BackgroundFill( Color.web(tfCor.getText()) , CornerRadii.EMPTY, Insets.EMPTY)));  
                numerOutraCor++;
                lblCor.setText("#Outra Cor: " +numerOutraCor);
            }
            
        });


        btnVerde.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("Oi botão azul - inline");
                PaneOrganizer.this.setBackground(new Background(new BackgroundFill(Color.rgb(0, 255, 0), CornerRadii.EMPTY, Insets.EMPTY)));
                numerVerde++;
                lblVerde.setText("#Verde: "+numerVerde);
            }
        });

        btnAzul.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("Oi botão azul - inline");
                PaneOrganizer.this.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 255), CornerRadii.EMPTY, Insets.EMPTY)));
                numeroAzul++;
                lblAzul.setText("#Azul: "+numeroAzul);
            }
        });




    }
}