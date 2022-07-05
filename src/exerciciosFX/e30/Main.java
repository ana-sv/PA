package exerciciosFX.e30;

import static exerciciosFX.e30.ui.gui.Constants.*;

import exerciciosFX.e30.logic.ModelManager;
import exerciciosFX.e30.ui.gui.RootPane;
import exerciciosFX.e30.ui.gui.text_panes.TextInfoListView;
import exerciciosFX.e30.ui.gui.text_panes.TextInfoPane;
import exerciciosFX.e30.ui.gui.text_panes.TextInfoScrollPane;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {        
        ModelManager model = new ModelManager();
        RootPane root = new RootPane(model);
                
        Scene scene = new Scene(root, ROOT_PANE_WIDTH, ROOT_PANE_HEIGHT);
        
        //primaryStage.setResizable(false);        
        primaryStage.setScene(scene); 
        primaryStage.setTitle("Drawing");

        primaryStage.setOnCloseRequest(ev -> Platform.exit());

        primaryStage.show();

        createAdditionalStage(model, primaryStage);
        createTextInfoStage(model, primaryStage);
        createTextInfoScrollStage(model, primaryStage);
        createTextInfoListViewStage(model, primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void createAdditionalStage(ModelManager model, Stage primaryStage) {
        Stage stage = new Stage();
        stage.setScene(new Scene(new RootPane(model),ROOT_PANE_WIDTH, ROOT_PANE_HEIGHT));
        stage.setX(primaryStage.getX()+200+Math.random()*100);
        stage.setY(primaryStage.getY()+200+Math.random()*100);
        stage.setResizable(false);
        stage.setOnCloseRequest(ev -> Platform.exit());
        stage.show();
    }

    public void createTextInfoStage(ModelManager observableModel, Stage primaryStage) {
        Stage stage = new Stage();
        stage.setScene(new Scene(new TextInfoPane(observableModel), TEXT_INFO_WIDTH, TEXT_INFO_HEIGHT));
        stage.setX(primaryStage.getX()+410);
        stage.setY(primaryStage.getY());
        stage.setOnCloseRequest(eh->Platform.exit());
        stage.show();
    }

    public void createTextInfoScrollStage(ModelManager observableModel, Stage primaryStage) {
        Stage stage = new Stage();
        stage.setScene(new Scene(new TextInfoScrollPane(observableModel), TEXT_INFO_WIDTH, TEXT_INFO_HEIGHT));
        stage.setX(primaryStage.getX()+410);
        stage.setY(primaryStage.getY()+400);
        stage.setOnCloseRequest(eh->Platform.exit());
        stage.show();
    }

    public void createTextInfoListViewStage(ModelManager observableModel, Stage primaryStage) {
        Stage stage = new Stage();
        stage.setScene(new Scene(new TextInfoListView(observableModel), TEXT_INFO_WIDTH, TEXT_INFO_HEIGHT));
        stage.setX(primaryStage.getX()+410);
        stage.setY(primaryStage.getY()+200);
        stage.setOnCloseRequest(eh->Platform.exit());
        stage.show();
    }

}
