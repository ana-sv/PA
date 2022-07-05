package exerciciosFX.e30.ui.gui.text_panes;


import static exerciciosFX.e30.logic.ModelManager.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import exerciciosFX.e30.logic.Figure;
import exerciciosFX.e30.logic.ModelManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;



public class TextInfoPane extends Pane implements PropertyChangeListener {
    private final ModelManager model;     
    private Label textInfo;

    public TextInfoPane(ModelManager model) {
        this.model = model;
        //model.addPropertyChangeListener(this);
        model.addPropertyChangeListener(FIGURES_SET_CHANGED, this);
        
        setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        textInfo =new Label();
        textInfo.setAlignment(Pos.CENTER);
        textInfo.setTextFill(Color.LIGHTGRAY);
        textInfo.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        textInfo.setFont(Font.font(12)); 
        updateTextInfo();
        
        getChildren().add(textInfo);
        
        setOnMouseEntered(eh-> {
            textInfo.setFont(Font.font(14));
            textInfo.setTextFill(Color.YELLOW);
        });
        
        setOnMouseExited(eh->{
            textInfo.setFont(Font.font(12));
            textInfo.setTextFill(Color.LIGHTGREY);
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        updateTextInfo();
    }
    
    public void updateTextInfo() {
        
        String s="";
        
        for(Figure oval:model.getFigures()){
            s += oval + System.lineSeparator();
        }
        
        textInfo.setText(s);
    } 
    
}
