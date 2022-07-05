package exemplosFX.tableview;

import java.util.ArrayList;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewWithUpdateListenerExample extends Application {

    ObservableList<Person> data ;

    @Override
    public void start(Stage primaryStage) {

        // Create an observable list with an extractor. This will ensure
        // listeners on the list receive notifications if any of the
        // properties returned by the extractor belonging to a list element
        // are changed:

       data = FXCollections.observableArrayList(person -> new Observable[] {
                person.firstNameProperty(),
                person.lastNameProperty(),
                person.emailProperty()
        });


        ArrayList<Person> p = new ArrayList<>();
        p.add(new Person("Jacob", "Smith", "jacob.smith@example.com"));
        p.add(new Person("Isabella", "Johnson", "isabella.johnson@example.com"));

        for (Person a : p) {
            data.add(a);
        }

       handlers();
  

        TableView<Person> tableView = new TableView<>();
        tableView.setEditable(true);
        tableView.setItems(data);

        tableView.getColumns().add(column("First Name", Person::firstNameProperty));

       // TableColumn<Person, String> col = new TableColumn<>("Friste name2");
        //col.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
       // col.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.getColumns().add(column("Last Name", Person::lastNameProperty));
        tableView.getColumns().add(column("Email", Person::emailProperty));

        TextField firstNameTF = new TextField();
        TextField lastNameTF = new TextField();
        TextField emailTF = new TextField();
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            Person person = new Person(firstNameTF.getText(), lastNameTF.getText(), emailTF.getText());
            firstNameTF.setText("");
            lastNameTF.setText("");
            emailTF.setText("");
            data.add(person);
        });

        GridPane editPane = new GridPane();
        editPane.addRow(0, new Label("First Name:"), firstNameTF);
        editPane.addRow(1, new Label("Last Name:"), lastNameTF);
        editPane.addRow(2, new Label("Email:"), emailTF);
        editPane.add(addButton, 0, 3, 2, 1);
        ColumnConstraints leftCol = new ColumnConstraints();
        leftCol.setHalignment(HPos.RIGHT);
        leftCol.setHgrow(Priority.NEVER);
        editPane.setHgap(10);
        editPane.setVgap(5);
        editPane.getColumnConstraints().addAll(leftCol, new ColumnConstraints());

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> data.remove(tableView.getSelectionModel().getSelectedItem()));
        deleteButton.disableProperty().bind(Bindings.isEmpty(tableView.getSelectionModel().getSelectedItems()));

        VBox root = new VBox(10, tableView, editPane, deleteButton);
        root.setAlignment(Pos.CENTER);

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    private TableColumn<Person, String> column(String title, Function<Person, ObservableValue<String>> property) {
        TableColumn<Person, String> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        col.setCellFactory(TextFieldTableCell.forTableColumn());
        return col;
    }

   private void handlers(){

    data.addListener((Change<? extends Person> c) -> {
        while (c.next()) {
            if (c.wasAdded()) {
                System.out.println("Added:");
                c.getAddedSubList().forEach(System.out::println);
                System.out.println();
            }
            if (c.wasRemoved()) {
                System.out.println("Removed:");
                c.getRemoved().forEach(System.out::println);
                System.out.println();
            }
            if (c.wasUpdated()) {
                System.out.println("Updated:");
                data.subList(c.getFrom(), c.getTo()).forEach(System.out::println);
                System.out.println();
            }
        }
    });

   }

    public static void main(String[] args) {
        launch(args);
    }
}