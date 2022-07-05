package exerciciosFX.e28a;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
 
    public PaneOrganizer() {
        createPane();
        //registerListener1();
        //registerListener2();
        //registerListener3();
        //registerListener4();
        registerListener5();
        numerVerde=0;
        numeroAzul=0;
    }
 
    void createPane() {
        btnVerde = new Button("Green");
        btnVerde.setTextFill(Color.GREEN);
        btnAzul = new Button("Blue");
        btnAzul.setTextFill(Color.BLUE);
        //numeros dinamicos
        lblVerde = new Label("#Verde: 0");
        lblAzul = new Label("#Azul: 0");
 
        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnVerde, btnAzul);
        hbox.setSpacing(25);
        hbox.setPadding(new Insets(10));
        hbox.setAlignment(Pos.CENTER);
        this.setTop(hbox);
         
        //numeros dinamicos
         HBox hboxlbl = new HBox();
        hboxlbl.getChildren().addAll(lblVerde, lblAzul);
        hboxlbl.setSpacing(25);
        hboxlbl.setPadding(new Insets(10));
        hboxlbl.setAlignment(Pos.CENTER);
        hboxlbl.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY)));
        this.setBottom(hboxlbl);

    }
 
    //1ºalternativa, usando uma inner class
    void registerListener1() {
        btnVerde.setOnAction(new ProgBotaoVerde1()); //o que vai ser executado, um objecto do tipo!
        btnAzul.setOnAction(new ProgBotaoAzul1()); //o que vai ser executado, um objecto do tipo!
    }
 
    class ProgBotaoVerde1 implements EventHandler<ActionEvent> {
 
        @Override
        public void handle(ActionEvent t) {
            //quando o botão for clicado
            System.out.println("Oi botão verde - inner class");
            //aceder ao objecto de fora ou então criar uma varivel ou via construtor
            PaneOrganizer.this.setBackground(new Background(new BackgroundFill(Color.rgb(0, 255, 0), CornerRadii.EMPTY, Insets.EMPTY)));
        }
 
    }
 
    class ProgBotaoAzul1 implements EventHandler<ActionEvent> {
 
        @Override
        public void handle(ActionEvent t) {
            //quando o botão for clicado
            System.out.println("Oi botão azul - inner class");
            //aceder ao objecto de fora ou então criar uma varivel ou via construtor
            PaneOrganizer.this.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 255), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }
 
    
    //2ºalternativa, usando uma classe inline
    void registerListener2() {
        btnVerde.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("Oi botão azul - inline");
                PaneOrganizer.this.setBackground(new Background(new BackgroundFill(Color.rgb(0, 255, 0), CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });
        btnAzul.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("Oi botão azul - inline");
                PaneOrganizer.this.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 255), CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });
    }
 
    //3ºalternativa, usando uma classe inline
    void registerListener3() {
        btnVerde.setOnAction(new ProcessaBotao(Color.GREEN)); //o que vai ser executado, um objecto do tipo!
        btnAzul.setOnAction(new ProcessaBotao(Color.BLUE)); //o que vai ser executado, um objecto do tipo!
    }
 
    class ProcessaBotao implements EventHandler<ActionEvent> {
        Color cor;
        public ProcessaBotao(Color cor) {
            this.cor = cor;
        }
        @Override
        public void handle(ActionEvent t) {
            //quando o botão for clicado
            System.out.println("Oi botão azul - inner class");
            //aceder ao objecto de fora ou então criar uma varivel ou via construtor
            PaneOrganizer.this.setBackground(new Background(new BackgroundFill(cor, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }
     
    //4ºalternativa, usando lambda functions
    void registerListener4() {
    btnVerde.setOnAction(
            (t)->{
                PaneOrganizer.this.setBackground(
                        new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            });
    
    btnAzul.setOnAction(
            (t)->{
                PaneOrganizer.this.setBackground(
                        new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            });
    }
     
    //dinamicos
    void registerListener5() {
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