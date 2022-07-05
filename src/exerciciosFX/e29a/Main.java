package exerciciosFX.e29a;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static void main(String[] args) {
        //passamos os argumentos para o subsistema gráfico os parametros
        launch(args); 
    }
  
    @Override
    //quando começa a aplicação
    public void start(Stage stage) throws Exception{
        PaneOrganizer po = new PaneOrganizer();
        Scene scene = new Scene(po,600,400);
        stage.setScene(scene); //aplica a cena no stage
        stage.setTitle("Exercicio de programação avançada");
        stage.setMinHeight(300.0);
        stage.setMinWidth(300.0);
        stage.show();
    }
}   