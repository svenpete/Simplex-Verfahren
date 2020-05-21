package TestEditableTable.Controller;

import Tableview.model.Variable;
import TestEditableTable.Model.Core.Calculation;
import TestEditableTable.Model.Schlupfvariable;
import TestEditableTable.View.AlertBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class tableController implements Initializable
{

    ObservableList<Integer> constraintsList =
            FXCollections.observableArrayList(1,2,3,4,5,6);

    ObservableList<Integer> variablesList =
            FXCollections.observableArrayList(1,2,3,4,5,6);

    @FXML
    private ComboBox<Integer> variables;

    @FXML
    private ComboBox<Integer> constraints;

    @FXML
    private TableView<Variable> table_info;

    @FXML
    private TableColumn<Variable, String> col_x1;

    @FXML
    private TableColumn<Variable, String> col_x2;

    @FXML
    private TableColumn<Variable, String> col_x3;

    @FXML
    private TableColumn<Variable, String> col_x4;

    @FXML
    private TableColumn<Variable, String> col_x5;

    @FXML
    private TableColumn<Variable, String> col_x6;

    @FXML
    private TableColumn<Variable, Button> col_update;

    @FXML
    private TableColumn<Variable,String> col_y1;

    @FXML
    private TableColumn<Schlupfvariable, String> col_s1;

    @FXML
    private TableColumn<Schlupfvariable, String> col_s2;

    @FXML
    private TableColumn<Schlupfvariable, String> col_s3;

    @FXML
    private TableColumn<Schlupfvariable, String> col_s4;

    @FXML
    private TableColumn<Schlupfvariable, String> col_s5;

    @FXML
    private TableColumn<Schlupfvariable, String> col_s6;


    @FXML
    private Button compute;

    @FXML
    void exit(ActionEvent event) {
    System.exit(1);
    }


    @FXML
    void createTable(ActionEvent event) {

        initTable(variables.getValue(),constraints.getValue());
    }

    public static ObservableList<Variable> data_table;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        constraints.setItems(constraintsList);
        variables.setItems(variablesList);
    }

    @FXML
    void compute(ActionEvent event){

       Float[][] values = getTableVariables();
        int count = 0;

        if (checkInput(values))
        {

            for (int i = 0; i < values.length; i++) {
                for (int j = 0; j < values[i].length ; j++) {
                    System.out.println( " Wertnummer " + count + ": " + values[i][j]);
                    count ++;
               }
            }
            Calculation calculation = new Calculation(values);
            calculation.solve();

        }
    }


    /** switches scenes to resulttablau
     * @throws IOException
     */
    void switchScene()
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/TestEditableTable/View/result.fxml"));
            Stage stage = (Stage) compute.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e )
        {
            e.printStackTrace();
        }
    }



    private void initTable(int colSize, int rowSize) {

        initCols(colSize);
        loadData(colSize,rowSize);

    }


    private Float[][] getTableVariables()
    {
        List<Variable> tableItems = table_info.getItems();
        Integer rowCount = Integer.parseInt(String.valueOf(constraints.getValue()));
        Integer columnCount = Integer.parseInt(String.valueOf(variables.getValue()));

        Float[][] variable = new Float[rowCount][columnCount + 1];

        for (int i = 0; i < rowCount; i++)
        {

                switch (variables.getValue())
                {
                    case 1:
                        variable[i][0] = Float.valueOf(tableItems.get(i).getX1());
                        variable[i][1] = Float.valueOf(tableItems.get(i).getY1());
                        break;
                    case 2:
                        variable[i][0] = Float.valueOf(tableItems.get(i).getX1());
                        variable[i][1] = Float.valueOf(tableItems.get(i).getX2());
                        variable[i][2] = Float.valueOf(tableItems.get(i).getY1());
                        break;
                    case 3:
                        variable[i][0] = Float.valueOf(tableItems.get(i).getX1());
                        variable[i][1] = Float.valueOf(tableItems.get(i).getX2());
                        variable[i][2] = Float.valueOf(tableItems.get(i).getX3());
                        variable[i][3] = Float.valueOf(tableItems.get(i).getY1());
                        break;
                    case 4:
                        variable[i][0] = Float.valueOf(tableItems.get(i).getX1());
                        variable[i][1] = Float.valueOf(tableItems.get(i).getX2());
                        variable[i][2] = Float.valueOf(tableItems.get(i).getX3());
                        variable[i][3] = Float.valueOf(tableItems.get(i).getX4());
                        variable[i][4] = Float.valueOf(tableItems.get(i).getY1());
                        break;
                    case 5:
                        variable[i][0] = Float.valueOf(tableItems.get(i).getX1());
                        variable[i][1] = Float.valueOf(tableItems.get(i).getX2());
                        variable[i][2] = Float.valueOf(tableItems.get(i).getX3());
                        variable[i][3] = Float.valueOf(tableItems.get(i).getX4());
                        variable[i][4] = Float.valueOf(tableItems.get(i).getX5());
                        variable[i][5] = Float.valueOf(tableItems.get(i).getY1());
                        break;
                    case 6:
                        variable[i][0] = Float.valueOf(tableItems.get(i).getX1());
                        variable[i][1] = Float.valueOf(tableItems.get(i).getX2());
                        variable[i][2] = Float.valueOf(tableItems.get(i).getX3());
                        variable[i][3] = Float.valueOf(tableItems.get(i).getX4());
                        variable[i][4] = Float.valueOf(tableItems.get(i).getX5());
                        variable[i][5] = Float.valueOf(tableItems.get(i).getX6());
                        variable[i][6] = Float.valueOf(tableItems.get(i).getY1());
                        break;

                }




            }

        /*

        for (int i = 0; i < tableItems.size(); i++)
        {
            for (int j = 0; j < columnCount ; j++)
            {
                switch (j)
                {
                    case 1:
                        variable[i][j] = Float.valueOf(tableItems.get(i).getX1());
                        break;
                    case 2:
                        variable[i][j] = Float.valueOf(tableItems.get(i).getX2());
                        break;

                    case 3:
                        variable[i][j] = Float.valueOf(tableItems.get(i).getX3());
                        break;
                    case 4:
                        variable[i][j] = Float.valueOf(tableItems.get(i).getX4());
                        break;
                    case 5:
                        variable[i][j] = Float.valueOf(tableItems.get(i).getX5());
                        break;
                    case 6:
                        variable[i][j] = Float.valueOf(tableItems.get(i).getX6());
                        break;

                }
                Integer spaceLeft = j - columnCount;

            }

        }


        */
        return variable;


    }

    private Float[][] createArray(List<Variable> variables){
        try{
        // rows
        int equation = variables.size();
        // columns
        Integer constraint = constraints.getValue();
        Float[][] values = new Float[equation][constraint];
        for (int i = 0; i < equation ; i++) {

                switch (constraint)
                {
                    case 1:
                        for (int j = 0; j < constraint; j++) {

                            if (isObjectFloat (variables.get(i).getX1() ))

                            if (j == 0)
                            values[i][j] = Float.valueOf(variables.get(i).getX1());
                        }

                        break;

                    case 2:
                        for (int j = 0; j < constraint; j++) {
                            if (j == 0)
                            values[i][j] = Float.valueOf(variables.get(i).getX1());
                            if (j == 1)
                            values[i][j] = Float.valueOf(variables.get(i).getX2());
                        }

                        break;

                    case 3:
                        for (int j = 0; j < constraint; j++) {
                            if (j == 0)
                                values[i][j] = Float.valueOf(variables.get(i).getX1());
                            if (j == 1)
                                values[i][j] = Float.valueOf(variables.get(i).getX2());
                            if (j == 2)
                                values[i][j] = Float.valueOf(variables.get(i).getX3());
                        }

                        break;

                    case 4:
                        for (int j = 0; j < constraint; j++) {
                            if (j == 0)
                                values[i][j] = Float.valueOf(variables.get(i).getX1());
                            if (j == 1)
                                values[i][j] = Float.valueOf(variables.get(i).getX2());
                            if (j == 2)
                                values[i][j] = Float.valueOf(variables.get(i).getX3());
                            if (j == 3)
                                values[i][j] = Float.valueOf(variables.get(i).getX3());
                        }

                        break;

                    case 5:
                        for (int j = 0; j < constraint; j++) {
                            if (j == 0)
                                values[i][j] = Float.valueOf(variables.get(i).getX1());
                            if (j == 1)
                                values[i][j] = Float.valueOf(variables.get(i).getX2());
                            if (j == 2)
                                values[i][j] = Float.valueOf(variables.get(i).getX3());
                            if (j == 3)
                                values[i][j] = Float.valueOf(variables.get(i).getX3());
                            if (j == 4)
                                values[i][j] = Float.valueOf(variables.get(i).getX4());
                        }
                        break;

                    case 6:
                        for (int j = 0; j < constraint; j++) {

                            if (j == 0)
                                values[i][j] = Float.valueOf(variables.get(i).getX1());
                            if (j == 1)
                                values[i][j] = Float.valueOf(variables.get(i).getX2());
                            if (j == 2)
                                values[i][j] = Float.valueOf(variables.get(i).getX3());
                            if (j == 3)
                                values[i][j] = Float.valueOf(variables.get(i).getX3());
                            if (j == 4)
                                values[i][j] = Float.valueOf(variables.get(i).getX4());
                            if (j == 5)
                                values[i][j] = Float.valueOf(variables.get(i).getX5());
                        }
                        break;
                }
        }
        return values;
        } catch (NumberFormatException e){
            e.printStackTrace();
            AlertBox.display("Warnung", "Fehlerhaftedarstellung.");

            return null;
        }
    }



    /** initialise columns
     *
     * @param colSize needed for variables initialise
     */
    private void initCols(int colSize)
    {
        col_update.setVisible(false);

        switch (colSize)
        {
            case 1:
                col_x1.setCellValueFactory
                        (new PropertyValueFactory<>("x1"));

                col_s1.setCellValueFactory(
                        new PropertyValueFactory<>("s1"));



                col_x1.setVisible(true);
                col_x2.setVisible(false);
                col_x3.setVisible(false);
                col_x4.setVisible(false);
                col_x5.setVisible(false);
                col_x6.setVisible(false);

                col_s1.setVisible(true);
                col_s2.setVisible(false);
                col_s3.setVisible(false);
                col_s4.setVisible(false);
                col_s5.setVisible(false);
                col_s6.setVisible(false);


                break;


            case 2:
                col_x1.setCellValueFactory
                        (new PropertyValueFactory<>("x1"));


                col_x2.setCellValueFactory
                        (new PropertyValueFactory<>("x2"));


                col_s1.setCellValueFactory(
                        new PropertyValueFactory<>("s1")
                );

                col_s2.setCellValueFactory(
                        new PropertyValueFactory<>("s2")
                );

                col_x1.setVisible(true);
                col_x2.setVisible(true);
                col_x3.setVisible(false);
                col_x4.setVisible(false);
                col_x5.setVisible(false);
                col_x6.setVisible(false);

                col_s1.setVisible(true);
                col_s2.setVisible(true);
                col_s3.setVisible(false);
                col_s4.setVisible(false);
                col_s5.setVisible(false);
                col_s6.setVisible(false);
                break;


            case 3:
                col_x1.setCellValueFactory
                        (new PropertyValueFactory<>("x1"));

                col_x2.setCellValueFactory
                        (new PropertyValueFactory<>("x2"));

                col_x3.setCellValueFactory
                        (new PropertyValueFactory<>("x3"));


                col_s1.setCellValueFactory
                        (new PropertyValueFactory<>("s1"));

                col_s2.setCellValueFactory
                        (new PropertyValueFactory<>("s2"));

                col_s3.setCellValueFactory
                        (new PropertyValueFactory<>("s3"));

                col_x1.setVisible(true);
                col_x2.setVisible(true);
                col_x3.setVisible(true);
                col_x4.setVisible(false);
                col_x5.setVisible(false);
                col_x6.setVisible(false);

                col_s1.setVisible(true);
                col_s2.setVisible(true);
                col_s3.setVisible(true);
                col_s4.setVisible(false);
                col_s5.setVisible(false);
                col_s6.setVisible(false);
                break;

            case 4:
                col_x1.setCellValueFactory
                    (new PropertyValueFactory<>("x1"));

                col_x2.setCellValueFactory
                        (new PropertyValueFactory<>("x2"));

                col_x3.setCellValueFactory
                        (new PropertyValueFactory<>("x3"));

                col_x4.setCellValueFactory
                        (new PropertyValueFactory<>("x4"));

                col_s1.setCellValueFactory
                        (new PropertyValueFactory<>("s1"));

                col_s2.setCellValueFactory
                        (new PropertyValueFactory<>("s2"));

                col_s3.setCellValueFactory
                        (new PropertyValueFactory<>("s3"));

                col_s4.setCellValueFactory
                        (new PropertyValueFactory<>("s4"));



                col_x1.setVisible(true);
                col_x2.setVisible(true);
                col_x3.setVisible(true);
                col_x4.setVisible(true);
                col_x5.setVisible(false);
                col_x6.setVisible(false);

                col_s1.setVisible(true);
                col_s2.setVisible(true);
                col_s3.setVisible(true);
                col_s4.setVisible(true);
                col_s5.setVisible(false);
                col_s6.setVisible(false);
                break;

            case 5:
                col_x1.setCellValueFactory
                        (new PropertyValueFactory<>("x1"));

                col_x2.setCellValueFactory
                        (new PropertyValueFactory<>("x2"));

                col_x3.setCellValueFactory
                        (new PropertyValueFactory<>("x3"));

                col_x4.setCellValueFactory
                        (new PropertyValueFactory<>("x4"));

                col_x5.setCellValueFactory
                        (new PropertyValueFactory<>("x5"));


                col_s1.setCellValueFactory
                        (new PropertyValueFactory<>("s1"));

                col_s2.setCellValueFactory
                        (new PropertyValueFactory<>("s2"));

                col_s3.setCellValueFactory
                        (new PropertyValueFactory<>("s3"));

                col_s4.setCellValueFactory
                        (new PropertyValueFactory<>("s4"));

                col_s5.setCellValueFactory
                        (new PropertyValueFactory<>("s5"));

                col_x1.setVisible(true);
                col_x2.setVisible(true);
                col_x3.setVisible(true);
                col_x4.setVisible(true);
                col_x5.setVisible(true);
                col_x6.setVisible(false);

                col_s1.setVisible(true);
                col_s2.setVisible(true);
                col_s3.setVisible(true);
                col_s4.setVisible(true);
                col_s5.setVisible(true);
                col_s6.setVisible(false);
                break;

            case 6:
                col_x1.setCellValueFactory
                        (new PropertyValueFactory<>("x1"));

                col_x2.setCellValueFactory
                        (new PropertyValueFactory<>("x2"));

                col_x3.setCellValueFactory
                        (new PropertyValueFactory<>("x3"));

                col_x4.setCellValueFactory
                        (new PropertyValueFactory<>("x4"));

                col_x5.setCellValueFactory
                        (new PropertyValueFactory<>("x5"));

                col_x6.setCellValueFactory
                        (new PropertyValueFactory<>("x6"));

                col_s1.setCellValueFactory
                        (new PropertyValueFactory<>("s1"));

                col_s2.setCellValueFactory
                        (new PropertyValueFactory<>("s2"));

                col_s3.setCellValueFactory
                        (new PropertyValueFactory<>("s3"));

                col_s4.setCellValueFactory
                        (new PropertyValueFactory<>("s4"));

                col_s5.setCellValueFactory
                        (new PropertyValueFactory<>("s5"));

                col_s6.setCellValueFactory
                        (new PropertyValueFactory<>("s6"));

                col_x1.setVisible(true);
                col_x2.setVisible(true);
                col_x3.setVisible(true);
                col_x4.setVisible(true);
                col_x5.setVisible(true);
                col_x6.setVisible(true);

                col_s1.setVisible(true);
                col_s2.setVisible(true);
                col_s3.setVisible(true);
                col_s4.setVisible(true);
                col_s5.setVisible(true);
                col_s6.setVisible(true);
                break;

        }
        col_y1.setCellValueFactory(new PropertyValueFactory<>("y1"));
        col_y1.setVisible(true);
        col_update.setCellValueFactory
                (new PropertyValueFactory<>("update"));

        editableCols(colSize);
    }

    /**
     * makes each cell in a given table editable und stores their new data
     * @param colSize to determine size of columns
     */
    private void editableCols(int colSize) {
        switch (colSize)
        {
            case 1:
                col_x1.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_x1.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX1(e.getNewValue());
                });
                break;


            case 2:

                col_x1.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_x1.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX1(e.getNewValue());
                });

                col_x2.setCellFactory(TextFieldTableCell.
                        forTableColumn());

                col_x2.setOnEditCommit(e -> {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX2(e.getNewValue());
                });
                break;

            case 3:

                col_x1.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_x1.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX1(e.getNewValue());
                });

                col_x2.setCellFactory(TextFieldTableCell.
                        forTableColumn());

                col_x2.setOnEditCommit(e -> {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX2(e.getNewValue());
                });

                col_x3.setCellFactory(TextFieldTableCell.
                        forTableColumn());

                col_x3.setOnEditCommit(e -> {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX3(e.getNewValue());
                });
                break;

            case 4:

                col_x1.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_x1.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX1(e.getNewValue());
                });

                col_x2.setCellFactory(TextFieldTableCell.
                        forTableColumn());

                col_x2.setOnEditCommit(e -> {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX2(e.getNewValue());
                });

                col_x3.setCellFactory(TextFieldTableCell.
                        forTableColumn());

                col_x3.setOnEditCommit(e -> {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX3(e.getNewValue());
                });

                col_x4.setCellFactory(TextFieldTableCell.
                        forTableColumn());

                col_x4.setOnEditCommit(e -> {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX4(e.getNewValue());


                });
                break;

            case 5:
                col_x1.setCellFactory
                    (TextFieldTableCell.forTableColumn());

                col_x1.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX1(e.getNewValue());
                });

                col_x2.setCellFactory(TextFieldTableCell.
                        forTableColumn());

                col_x2.setOnEditCommit(e -> {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX2(e.getNewValue());
                });

                col_x3.setCellFactory(TextFieldTableCell.
                        forTableColumn());

                col_x3.setOnEditCommit(e -> {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX3(e.getNewValue());
                });

                col_x4.setCellFactory(TextFieldTableCell.
                        forTableColumn());

                col_x4.setOnEditCommit(e -> {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX4(e.getNewValue());


                });
                col_x5.setCellFactory(TextFieldTableCell.forTableColumn());
                col_x5.setOnEditCommit(e ->{
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX5(e.getNewValue());
                });
                break;

            case 6:
                col_x1.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_x1.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX1(e.getNewValue());
                });

                col_x2.setCellFactory(TextFieldTableCell.
                        forTableColumn());

                col_x2.setOnEditCommit(e -> {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX2(e.getNewValue());
                });

                col_x3.setCellFactory(TextFieldTableCell.
                        forTableColumn());

                col_x3.setOnEditCommit(e -> {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX3(e.getNewValue());
                });

                col_x4.setCellFactory(TextFieldTableCell.
                        forTableColumn());

                col_x4.setOnEditCommit(e -> {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX4(e.getNewValue());


                });

                col_x5.setCellFactory(TextFieldTableCell.forTableColumn());
                col_x5.setOnEditCommit(e ->{
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX5(e.getNewValue());
                });

                col_x6.setCellFactory(TextFieldTableCell.forTableColumn());
                col_x6.setOnEditCommit(e ->{
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setX6(e.getNewValue());
                });
                break;
        }

        col_y1.setCellFactory(TextFieldTableCell.forTableColumn());
        col_y1.setOnEditCommit( e ->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setY1(e.getNewValue());
        });


        table_info.setEditable(true);
    }

    /**
     *  loads data into table
     * @param rows to determine size of variable constructor
     * @param columns to determine size of constraints
     */
    private void loadData(int rows, int columns) {
        data_table= FXCollections.observableArrayList();

        for (int i = 0; i < columns; i++)
        {
            switch (rows)
            {
                case 1 :
                    data_table.add(new Variable(
                                    "1.00", "5.00"));

                    break;

                case 2 :
                    data_table.add(new Variable("1.00", "2.00", "2.00"));

                    break;

                case 3 :
                    data_table.add(new Variable(
                            "1.00", "2.00","3.00", "3.00"));

                    break;

                case 4 : data_table.add(new Variable(
                        "1.00", "2.00","3.00", "4.00",  "5.00"));


                    break;

                case 5 :
                    data_table.add(new Variable(
                            "1.00", "2.00", "3.00", "4.00", "5.00", "4.00"));
                    /*
                    data_table.add(new Schlupfvariable("1.00","0.00","0.00","0.00","0.00"));
                    data_table.add(new Schlupfvariable("0.00","1.00","0.00","0.00","0.00"));
                    data_table.add(new Schlupfvariable("0.00","0.00","1.00","0.00","0.00"));
                    data_table.add(new Schlupfvariable("0.00","0.00","0.00","1.00","0.00"));
                    data_table.add(new Schlupfvariable("0.00","0.00","0.00","0.00","1.00"));

                     */
                    break;

                case 6 :
                    data_table.add(new Variable("1.00", "2.00", "3.00", "4.00", "5.00","6.00", "2.00"));

                    data_table.add(new Schlupfvariable("1.00","0.00","0.00","0.00","0.00","0.00"));
                    data_table.add(new Schlupfvariable("0.00","1.00","0.00","0.00","0.00","0.00"));
                    data_table.add(new Schlupfvariable("0.00","0.00","1.00","0.00","0.00","0.00"));
                    data_table.add(new Schlupfvariable("0.00","0.00","0.00","1.00","0.00","0.00"));
                    data_table.add(new Schlupfvariable("0.00","0.00","0.00","0.00","1.00","0.00"));
                    data_table.add(new Schlupfvariable("0.00","0.00","0.00","0.00","0.00","1.00"));


                    break;
            }

        }
        table_info.setItems(data_table);
    }

    /**
     *
     * @param o is the object to check for floating numbers
     * @return
     */
    public boolean isObjectFloat(Object o)
    {
        return o instanceof Float;
    }


    public boolean checkInput(Float[][] variables) {
        boolean inputValid = false;
        int equation = table_info.getItems().size();

        for (int i = 0; i < variables.length; i++) {
            for (int j = 0; j < variables[i].length; j++) {
                if ( isObjectFloat( variables[i][j]))
                {
                    inputValid = true;
                }
                else {
                    inputValid = false;


                    return inputValid;
                }
            }

        }
        return inputValid;
    }

 
}