package exerciciosFX.e30.ui.gui;


import static exerciciosFX.e30.logic.ModelManager.FIGURES_SET_CHANGED;
import static exerciciosFX.e30.ui.gui.Constants.*;

import java.io.File;
import java.io.IOException;

import exerciciosFX.e30.logic.ModelManager;
import exerciciosFX.e30.ui.resources.ImageLoader;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class MyMenuBar extends MenuBar {
    
    ModelManager model;
    Window ownerWindow;
    
    Menu options;
    MenuItem clear, load, save, undo, exit;
    
    public MyMenuBar(ModelManager model, Window ownerWindow) {
        this.model = model;
        this.ownerWindow = ownerWindow;
        
        model.addPropertyChangeListener(FIGURES_SET_CHANGED, (evt)->update());
        
        options = new Menu("_Options");
        
        clear = new MenuItem("_Clear");
        load = new MenuItem("_Load");
        save = new MenuItem("_Save");        
        undo = new MenuItem("_Undo");
        exit = new MenuItem("E_xit");
        
        options.getItems().setAll(clear, new SeparatorMenuItem(), load, save,
                undo, new SeparatorMenuItem(), exit);   
        
        this.getMenus().add(options); 

        clear.setAccelerator(KeyCombination.keyCombination("SHORTCUT+C"));        
        load.setAccelerator(KeyCombination.keyCombination("SHORTCUT+L"));        
        save.setAccelerator(KeyCombination.keyCombination("SHORTCUT+S"));        
        undo.setAccelerator(KeyCombination.keyCombination("SHORTCUT+Z"));        
        exit.setAccelerator(KeyCombination.keyCombination("SHORTCUT+X"));
        
        clear.setOnAction(evt -> model.clear());
        undo.setOnAction(evt -> model.undo());
        save.setOnAction(evt -> saveOption());
        load.setOnAction(evt -> loadOption());
        exit.setOnAction(evt -> Platform.exit());
                
        Image undoIcon = ImageLoader.getImage("undo-icon.png");
        ImageView undoImageView = new ImageView(undoIcon);
        undoImageView.setFitHeight(BUTTON_WIDTH_HEIGHT);
        undoImageView.setPreserveRatio(true);
        
        undo.setGraphic(undoImageView);
        
        Image clearIcon = ImageLoader.getImage("undo-all-icon.png");
        ImageView clearImageView = new ImageView(clearIcon);
        clearImageView.setFitHeight(BUTTON_WIDTH_HEIGHT);
        clearImageView.setPreserveRatio(true);    
        
        clear.setGraphic(clearImageView);
        
        update();
    }
    
    private void saveOption() {
        FileChooser fChooser = new FileChooser();
        File f = fChooser.showSaveDialog(ownerWindow);

        if(f==null)
            return;

        try {
            model.saveModel(f.getCanonicalPath());
        } catch (IOException ex) {
            showAlert("Serializing model to " + f.getName() + "...", ex.toString());
        }
    }
    
    private void loadOption() {
        FileChooser fChooser = new FileChooser();
        File f = fChooser.showOpenDialog(ownerWindow);

        if(f==null)
            return;

        try {
            model.loadModel(f.getCanonicalPath());
        } catch (IOException | ClassNotFoundException ex) {
            showAlert("Getting model from " + f.getName() + "...", ex.toString());
        }
    }
    
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(title);                    
        alert.setContentText(msg);
        alert.showAndWait(); 
    }

    public void update() {
        clear.setDisable(model.getFigures().isEmpty());
        undo.setDisable(model.getFigures().isEmpty());
        save.setDisable(model.getFigures().isEmpty());
    }        
    
}
