package exerciciosFX.e30.ui.gui;


import static exerciciosFX.e30.logic.ModelManager.*;
import static exerciciosFX.e30.ui.gui.Constants.*;

import exerciciosFX.e30.logic.Figure.EFigureType;
import exerciciosFX.e30.logic.ModelManager;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;


public class ShapeSelectionPanes extends HBox {
    private final ModelManager model;
    private final ShapeSelectionPane rectPane;
    private final ShapeSelectionPane circlePane;
    private final ShapeSelectionPane linePane;
    
    public ShapeSelectionPanes(ModelManager model) {
        this.model = model;
        
        rectPane = new ShapeSelectionPane(EFigureType.RECT);
        circlePane = new ShapeSelectionPane(EFigureType.OVAL);
        linePane = new ShapeSelectionPane(EFigureType.LINE);
        
        getChildren().addAll(rectPane, circlePane, linePane);
        setAlignment(Pos.CENTER);
        setSpacing(SPACE_BETWEEN_ITEMS);
    }    
       
    class ShapeSelectionPane extends Pane {
        private EFigureType myShape;

        public ShapeSelectionPane(EFigureType myShape) {
            this.myShape = myShape;            
            
            model.addPropertyChangeListener(CURRENT_SHAPE_CHANGED, evt -> updateMyBorder());
            
            setHeight(BUTTON_WIDTH_HEIGHT+BORDER_WIDTH);
            setWidth(BUTTON_WIDTH_HEIGHT+BORDER_WIDTH);
            setMaxSize(BUTTON_WIDTH_HEIGHT+BORDER_WIDTH, BUTTON_WIDTH_HEIGHT+BORDER_WIDTH);
            
            switch (myShape){
                case RECT -> getChildren().add(new Rectangle(MARGIN, MARGIN,
                                getWidth()-2*MARGIN, getHeight()-2*MARGIN));
                case OVAL-> getChildren().add(new Circle(getWidth()/2,getHeight()/2,
                                Math.min(getWidth(), getHeight())/2.0-MARGIN));
                case LINE -> getChildren().add(new Line(MARGIN, MARGIN,
                                getWidth()-MARGIN, getHeight()-MARGIN));
            }
            
            setOnMouseClicked(eh -> model.setCurrentShape(myShape));
            updateMyBorder();
        }

        private void updateMyBorder() {
            if(model.getCurrentShape() == myShape){
                setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID, null, new BorderWidths(BORDER_WIDTH))));
            }else{
                setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.NONE, null, new BorderWidths(BORDER_WIDTH))));
            }
        }
        
    }
    
}
