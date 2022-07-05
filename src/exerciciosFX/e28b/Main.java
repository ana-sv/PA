package exerciciosFX.e28b;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class Main extends Application {
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("onInit");
    }
 
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("onStart");
        PaneOrganizer brd = new PaneOrganizer();
         Scene scene = new Scene(brd, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Programação avançada");
        stage.show();
    }
 
    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("onStop");
    }
}