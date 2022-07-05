package exerciciosFX.e30.ui.gui;


import static exerciciosFX.e30.logic.ModelManager.*;

import java.beans.PropertyChangeEvent;

import exerciciosFX.e30.logic.ModelManager;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class RootPane extends StackPane {
    ModelManager model;

    DrawingPane drawingPane;
    Button startButton;

    public RootPane(ModelManager model){

        this.model = model;

        model.addPropertyChangeListener(VISIBILITY_STATE_CHANGED, (PropertyChangeEvent evt) -> update());

        //cria componentes
        drawingPane = new DrawingPane(model);
        startButton = new Button("Show");

        //compoe vista
        getChildren().addAll(startButton, drawingPane);

        //adiciona event handlers
        startButton.setOnAction(evt -> model.setVisible(true));

        update();
    }

    private void update() {
        drawingPane.setVisible(model.isVisible());
        startButton.setVisible(!model.isVisible());
    }

}
