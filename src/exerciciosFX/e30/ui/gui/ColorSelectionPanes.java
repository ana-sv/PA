package exerciciosFX.e30.ui.gui;

import static exerciciosFX.e30.logic.ModelManager.*;
import static exerciciosFX.e30.ui.gui.Constants.*;

import exerciciosFX.e30.logic.ModelManager;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class ColorSelectionPanes extends HBox {
    private final ModelManager modelManager;

    private final ColorSelectionPane redPane;
    private final ColorSelectionPane greenPane;
    private final ColorSelectionPane bluePane;
    
    public ColorSelectionPanes(ModelManager modelManager) {
        this.modelManager = modelManager;
        
        redPane = new ColorSelectionPane(255, 0, 0);
        greenPane = new ColorSelectionPane(0, 255, 0);
        bluePane = new ColorSelectionPane(0, 0, 255);
        
        getChildren().addAll(redPane, greenPane, bluePane);
        setAlignment(Pos.CENTER);        
        setSpacing(SPACE_BETWEEN_ITEMS);
    }    
       
    class ColorSelectionPane extends Rectangle {
        private int r, g, b;

        public ColorSelectionPane(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
            
            modelManager.addPropertyChangeListener(CURRENT_COLOR_CHANGED, evt->updateMyBorder());
                        
            setWidth(BUTTON_WIDTH_HEIGHT);
            setHeight(BUTTON_WIDTH_HEIGHT);
            setMaxSize(BUTTON_WIDTH_HEIGHT, BUTTON_WIDTH_HEIGHT);

            setFill(Color.rgb(r, g, b));

            setOnMouseClicked(evt -> modelManager.setCurrentColor(r, g, b));
            updateMyBorder();
        }

        private void updateMyBorder() {
            if(modelManager.getCurrentR()==r && modelManager.getCurrentG()==g && modelManager.getCurrentB()==b){
                setStroke(Color.BLACK);
                setStrokeType(StrokeType.OUTSIDE);
                setStrokeWidth(BORDER_WIDTH);
            }else{
                setStroke(null);
            }
        }        
        
    }
}