package exerciciosFX.e30.ui.gui.text_panes;


import exerciciosFX.e30.logic.Figure;
import exerciciosFX.e30.logic.ModelManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class TextInfoListView extends ListView<Figure> {
    ModelManager observableModel;
    ObservableList<Figure> listItems;

    public TextInfoListView(ModelManager observableModel) {
        this.observableModel = observableModel;
        listItems = FXCollections.observableArrayList();

        //observableModel.addPropertyChangeListener(this);
        observableModel.addPropertyChangeListener(ModelManager.FIGURES_SET_CHANGED,
                evt-> setViewList());

        this.setItems(listItems);
        setViewList();
    }

    public void setViewList() {
        listItems.setAll(observableModel.getFigures());
    }
}
