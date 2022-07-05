package exerciciosFX.e30.ui.gui.text_panes;

import static exerciciosFX.e30.logic.ModelManager.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import exerciciosFX.e30.logic.Figure;
import exerciciosFX.e30.logic.ModelManager;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class TextInfoScrollPane extends ScrollPane implements PropertyChangeListener {
    private ModelManager model;     
    private Label textInfo;

    public TextInfoScrollPane(ModelManager observableModel) {
        
        this.model = observableModel;
        //observableModel.addPropertyChangeListener(this);
        observableModel.addPropertyChangeListener(FIGURES_SET_CHANGED, this);
                
        textInfo =new Label();
        textInfo.setAlignment(Pos.CENTER);        
        textInfo.setFont(Font.font(12)); 
        
        setContent(textInfo);
        
        setOnMouseEntered(eh-> {
            textInfo.setFont(Font.font(14));
            textInfo.setTextFill(Color.DARKBLUE);
        });
        
        setOnMouseExited(eh->{
            textInfo.setFont(Font.font(12));
            textInfo.setTextFill(Color.BLACK);
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
