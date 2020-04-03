package TestEditableTable;

import Tableview.model.Variable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{

    @FXML
    private TableView<Variable> table_info;

    public static TableView<Variable> table_info_2;

    @FXML
    private TableColumn<Variable, String> col_x1;

    @FXML
    private TableColumn<Variable, String> col_x2;

    @FXML
    private TableColumn<Variable, String> col_x3;

    @FXML
    private TableColumn<Variable, String> col_x4;

    @FXML
    private TableColumn<Variable, Button> col_update;

    public static ObservableList<Variable> data_table;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        table_info_2 = table_info;
        initTable();
        loadData();
    }

    private void initTable() {
        initCols();

    }
    // need to be changed to dynmaic
    private void initCols() {
        col_x1.setCellValueFactory(new PropertyValueFactory<>("x1"));
        col_x2.setCellValueFactory(new PropertyValueFactory<>("x2"));
        col_x3.setCellValueFactory(new PropertyValueFactory<>("x3"));
        col_x4.setCellValueFactory(new PropertyValueFactory<>("x4"));
        col_update.setCellValueFactory(new PropertyValueFactory<>("update"));

        editableCols();
    }
    // here we need a concept which decides wether the dynamic input of cols is editable for every new column
    private void editableCols() {
        col_x1.setCellFactory(TextFieldTableCell.forTableColumn());

        col_x1.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setId(e.getNewValue());
        });
        col_x2.setCellFactory(TextFieldTableCell.forTableColumn());

        col_x2.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setX2(e.getNewValue());
        });

        col_x3.setCellFactory(TextFieldTableCell.forTableColumn());

        col_x3.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setX3(e.getNewValue());
        });

        col_x4.setCellFactory(TextFieldTableCell.forTableColumn());

        col_x4.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setX4(e.getNewValue());
        });

        table_info.setEditable(true);
    }

    // loads information in the table
    private void loadData()
    {
        data_table= FXCollections.observableArrayList();

        for (int i = 0; i < 7; i++)
        {
            data_table.add(new Variable( String.valueOf(i),
                    "test" + i, "test" + i, "test" + i, new Button("update")));

        }
        table_info.setItems(data_table);
    }
}