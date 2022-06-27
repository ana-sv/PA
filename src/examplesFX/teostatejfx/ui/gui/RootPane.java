package examplesFX.teostatejfx.ui.gui;

import examplesFX.teostatejfx.model.ModelManager;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class RootPane extends BorderPane {
    ModelManager model;

    public RootPane(ModelManager model) {
        this.model = model;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        StackPane stackPane = new StackPane(
                new BeginUI(model), new MessageDefinitionUI(model),
                new NumberDefinitionUI(model), new ShowDataUI(model) );
        this.setCenter(stackPane);

        this.setBottom(new StatusBar(model));
    }

    private void registerHandlers() { }

    private void update() { }
}
