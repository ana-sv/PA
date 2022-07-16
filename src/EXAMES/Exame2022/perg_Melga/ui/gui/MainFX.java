package EXAMES.Exame2022.perg_Melga.ui.gui;

import EXAMES.Exame2022.perg_Melga.model.MelgaManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {
    MelgaManager mm; 


    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void init() throws Exception {
        super.init();
        mm = new MelgaManager(); 
    }
 
    @Override
    public void start(Stage stage) throws Exception {

        RootPane root = new RootPane(mm); 
        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.setTitle("Melga");  // falta centrar este titulo, mas isso nao fazia parte do exercicio
        stage.show();
    }
    
}
