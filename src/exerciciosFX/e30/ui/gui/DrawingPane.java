package exerciciosFX.e30.ui.gui;

import static exerciciosFX.e30.logic.ModelManager.*;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import exerciciosFX.e30.logic.ModelManager;
import exerciciosFX.e30.ui.resources.ImageLoader;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

public class DrawingPane extends BorderPane {

    private final ModelManager model;
    private final MyCanvas canvas;
    private Button undoButton, clearButton, saveButton, loadButton;
    private Button hideButton, changeColorsButton;
    ShapeSelectionPanes shapesSelection;
    ColorSelectionPanes colorsSelection;

    public static final int BORDER_WIDTH = 2;

    public DrawingPane(ModelManager model ) {

        this.model = model;
        model.addPropertyChangeListener(FIGURES_SET_CHANGED, evt -> update());

        // I - Create the graphical components (nodes) of the pane
        canvas = new MyCanvas(model, Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT);

        undoButton = new Button("undo");
        clearButton = new Button("clear");
        saveButton = new Button("save");
        loadButton = new Button("load");
        hideButton = new Button("hide");
        changeColorsButton = new Button(); // Button(model.isChangeColors() ? "Stop colors" : "Start colors");

        setButtonIcon(clearButton, "undo-all-icon.png");
        setButtonIcon(undoButton, "undo-icon.png");

        shapesSelection = new ShapeSelectionPanes(model);
        colorsSelection = new ColorSelectionPanes(model);

        // Set some properties
        this.setBorder(new Border(new BorderStroke(Color.DARKVIOLET, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(BORDER_WIDTH))));

        // II - Arrange the pane
        setCenter(canvas);

        HBox topHBox = new HBox();
        topHBox.setSpacing(Constants.SPACE_BETWEEN_ITEMS);
        topHBox.setTranslateY(Constants.MARGIN);
        topHBox.setAlignment(Pos.CENTER);
        topHBox.getChildren().addAll(undoButton, clearButton, saveButton, loadButton, hideButton, changeColorsButton);

        VBox topVBox = new VBox();
        topVBox.getChildren().addAll(new MyMenuBar(model, null), topHBox);
        setTop(topVBox);

        HBox bottomHBox = new HBox();
        bottomHBox.setSpacing(6 * Constants.SPACE_BETWEEN_ITEMS);
        bottomHBox.setAlignment(Pos.CENTER);
        bottomHBox.getChildren().addAll(shapesSelection, colorsSelection);
        setBottom(bottomHBox);

        // III - Set the event handlers
        setEventHandlers();

        update();
        scheduleChangingColorsBasedOnTimer();
    }

    private void setEventHandlers() {

        undoButton.setOnAction(evt -> {
            model.undo();
        });

        clearButton.setOnAction(evt -> {
            model.clear();
        });

        saveButton.setOnAction(evt -> {
            FileChooser fChooser = new FileChooser();
            File f = fChooser.showSaveDialog(null);

            if (f == null)
                return;

            try {
                model.saveModel(f.getCanonicalPath());
            } catch (IOException e) {
                System.err.println("Save: " + e);
            }
        });

        loadButton.setOnAction(evt -> {
            FileChooser fChooser = new FileChooser();
            File f = fChooser.showOpenDialog(null);

            if (f == null)
                return;

            try {
                model.loadModel(f.getCanonicalPath());
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Save: " + e);
            }
        });

        hideButton.setOnAction(evt -> model.setVisible(false));
        changeColorsButton.setOnAction(evt -> model.setChangeColors(!model.isChangeColors()));
    }

    protected void update() {
        undoButton.setDisable(model.getFigures().isEmpty());
        clearButton.setDisable(model.getFigures().isEmpty());
        changeColorsButton.setText(model.isChangeColors() ? "Stop colors" : "Start colors");
    }

    private void setButtonIcon(Button b, String imagePath) {
        Image image = ImageLoader.getImage(imagePath);

        if (image == null)
            return;

        ImageView iv = new ImageView(image);
        iv.setFitHeight(15);
        iv.setPreserveRatio(true);
        b.setGraphic(iv);
    }

    private void scheduleChangingColorsBasedOnTimer() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> model.changeFiguresColors());
            }
        }, 0, 1000);
    }

    /*
     * private void scheduleChangingColorsBasedOnTimeline() {
     * Timeline timeline = new Timeline(new KeyFrame(
     * Duration.millis(500),
     * ae -> model.changeFiguresColors()));
     * 
     * timeline.setCycleCount(Animation.INDEFINITE);
     * timeline.play(); //pause() e stop()
     * }
     */

}
