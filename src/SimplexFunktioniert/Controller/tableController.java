package SimplexFunktioniert.Controller;

import SimplexFunktioniert.Core.steps;
import SimplexFunktioniert.Core.EigenerSimplexTester;
import SimplexFunktioniert.Model.Variable;
import SimplexFunktioniert.View.AlertBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class tableController implements Initializable
{


    ObservableList<Integer> constraintsList =
            FXCollections.observableArrayList(2,3,4,5,6);

    ObservableList<Integer> variablesList =
            FXCollections.observableArrayList(2,3,4,5,6);

    public static ObservableList<Variable> data_table;

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
    private TableColumn<Variable, String> col_s1;

    @FXML
    private TableColumn<Variable, String> col_s2;

    @FXML
    private TableColumn<Variable, String> col_s3;

    @FXML
    private TableColumn<Variable, String> col_s4;

    @FXML
    private TableColumn<Variable, String> col_s5;

    @FXML
    private TableColumn<Variable, String> col_s6;

    @FXML
    private TextArea output_1;

    @FXML
    private TextArea output_2;

    @FXML
    private TextArea output_3;

    @FXML
    private TextArea output_4;

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


    /**
     * starting method to load the GUI
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        constraints.setItems(constraintsList);
        variables.setItems(variablesList);
    }

    /**
     * method to start the calculation in the core
     */
    @FXML
    void compute(ActionEvent event){
        float[][] values = getTableVariables();


        if (checkInput(values))
        {
            float[][] table = EigenerSimplexTester.berechne(constraints.getValue(),(variables.getValue() + variables.getValue()),values );





            for (int i = 1; i<= 2; i++){
                String value ="";

                switch (i){
                    case 1:
                        System.out.println("Test case 1");
                        float[][] irgendwas1 = table;
                        //System.out.println("ZT1: "+irgendwas1[2][0]);
                        for (int k = 0; k < irgendwas1.length; k++) {
                            for (int j = 0; j < irgendwas1[0].length; j++) {
                                value = value+"  "+ String.format("%.2f", irgendwas1[k][j]);

                            }
                            value = value+"\n";
                        }
                        fillData(value,i);
                        break;
                    case 2:
                       // System.out.println("Test case 2");
                       float[][] irgendwas2 = table;
                      //  System.out.println("ZT1: "+irgendwas2[2][0]);
                        for (int k = 0; k < irgendwas2.length; k++) {
                            for (int j = 0; j < irgendwas2[0].length; j++) {
                                value = value+"  "+ String.format("%.2f", irgendwas2[k][j]);

                            }
                            value = value+"\n";
                        }
                        fillData(value,i);

                        break;
                }

        }


        }


    }


    private void initTable(int colSize, int rowSize)
    {
        initColumns(colSize,rowSize);
        loadData(rowSize,colSize,true);

    }


    /**
     * Method to save the entries from the entering table into an multidimensional array for later calculations
     * @return the
     */
    private float[][] getTableVariables()
    {
        try{

            List<Variable> tableItems = table_info.getItems();
            Integer rowCount = 1 + Integer.parseInt(String.valueOf(constraints.getValue()));
            Integer columnCount = Integer.parseInt(String.valueOf(variables.getValue()));


            float[][] variable = new float[rowCount][];
        for (int i = 0; i < rowCount ; i++)
        {

                switch (variables.getValue()) {
                    case 1:

                        variable[i] = new float[columnCount + 2];
                        variable[i][0] = Float.valueOf(tableItems.get(i).getX1());

                        variable[i][1] = Float.valueOf(tableItems.get(i).getS1());

                        variable[i][2] = Float.valueOf(tableItems.get(i).getY1());
                        break;
                    case 2:

                        variable[i] = new float[columnCount + 3];
                        variable[i][0] = Float.valueOf(tableItems.get(i).getX1());
                        variable[i][1] = Float.valueOf(tableItems.get(i).getX2());

                        variable[i][2] = Float.valueOf(tableItems.get(i).getS1());
                        variable[i][3] = Float.valueOf(tableItems.get(i).getS2());

                        variable[i][4] = Float.valueOf(tableItems.get(i).getY1());
                        break;
                    case 3:
                        variable[i] = new float[columnCount + 4];
                        variable[i][0] = Float.valueOf(tableItems.get(i).getX1());
                        variable[i][1] = Float.valueOf(tableItems.get(i).getX2());
                        variable[i][2] = Float.valueOf(tableItems.get(i).getX3());

                        variable[i][3] = Float.valueOf(tableItems.get(i).getS1());
                        variable[i][4] = Float.valueOf(tableItems.get(i).getS2());
                        variable[i][5] = Float.valueOf(tableItems.get(i).getS3());

                        variable[i][6] = Float.valueOf(tableItems.get(i).getY1());
                        break;
                    case 4:
                        variable[i] = new float[columnCount + 5];
                        variable[i][0] = Float.valueOf(tableItems.get(i).getX1());
                        variable[i][1] = Float.valueOf(tableItems.get(i).getX2());
                        variable[i][2] = Float.valueOf(tableItems.get(i).getX3());
                        variable[i][3] = Float.valueOf(tableItems.get(i).getX4());

                        variable[i][4] = Float.valueOf(tableItems.get(i).getS1());
                        variable[i][5] = Float.valueOf(tableItems.get(i).getS2());
                        variable[i][6] = Float.valueOf(tableItems.get(i).getS3());
                        variable[i][7] = Float.valueOf(tableItems.get(i).getS4());

                        variable[i][8] = Float.valueOf(tableItems.get(i).getY1());
                        break;
                    case 5:
                        variable[i] = new float[columnCount + 6];
                        variable[i][0] = Float.valueOf(tableItems.get(i).getX1());
                        variable[i][1] = Float.valueOf(tableItems.get(i).getX2());
                        variable[i][2] = Float.valueOf(tableItems.get(i).getX3());
                        variable[i][3] = Float.valueOf(tableItems.get(i).getX4());
                        variable[i][4] = Float.valueOf(tableItems.get(i).getX5());

                        variable[i][5] = Float.valueOf(tableItems.get(i).getS1());
                        variable[i][6] = Float.valueOf(tableItems.get(i).getS2());
                        variable[i][7] = Float.valueOf(tableItems.get(i).getS3());
                        variable[i][8] = Float.valueOf(tableItems.get(i).getS4());
                        variable[i][9] = Float.valueOf(tableItems.get(i).getS5());

                        variable[i][10] = Float.valueOf(tableItems.get(i).getY1());
                        break;
                    case 6:
                        variable[i] = new float[columnCount + 7];
                        variable[i][0] = Float.valueOf(tableItems.get(i).getX1());
                        variable[i][1] = Float.valueOf(tableItems.get(i).getX2());
                        variable[i][2] = Float.valueOf(tableItems.get(i).getX3());
                        variable[i][3] = Float.valueOf(tableItems.get(i).getX4());
                        variable[i][4] = Float.valueOf(tableItems.get(i).getX5());
                        variable[i][5] = Float.valueOf(tableItems.get(i).getX6());

                        variable[i][6] = Float.valueOf(tableItems.get(i).getS1());
                        variable[i][7] = Float.valueOf(tableItems.get(i).getS2());
                        variable[i][8] = Float.valueOf(tableItems.get(i).getS3());
                        variable[i][9] = Float.valueOf(tableItems.get(i).getS4());
                        variable[i][10] = Float.valueOf(tableItems.get(i).getS5());
                        variable[i][11] = Float.valueOf(tableItems.get(i).getS6());

                        variable[i][12] = Float.valueOf(tableItems.get(i).getY1());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + variables.getValue());
                }
            }
        return variable;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            AlertBox.display("Warnung", "Fehlerhaftedarstellung!");
            return null;
        }
    }


    /**
     * define the number of columns needed for the entry table
     * @param colSize to determine size of columns
     * @param NBB to determine the columns which are needed for the slack variables
     */
    private void initColumns(int colSize, int NBB)
    {

        switch (colSize)
        {
            case 1:
                col_x1.setCellValueFactory
                        (new PropertyValueFactory<>("x1"));

                col_x1.setVisible(true);
                col_x2.setVisible(false);
                col_x3.setVisible(false);
                col_x4.setVisible(false);
                col_x5.setVisible(false);
                col_x6.setVisible(false);
                break;

            case 2:
                col_x1.setCellValueFactory
                        (new PropertyValueFactory<>("x1"));


                col_x2.setCellValueFactory
                        (new PropertyValueFactory<>("x2"));

                col_x1.setVisible(true);
                col_x2.setVisible(true);
                col_x3.setVisible(false);
                col_x4.setVisible(false);
                col_x5.setVisible(false);
                col_x6.setVisible(false);
                break;

            case 3:
                col_x1.setCellValueFactory
                        (new PropertyValueFactory<>("x1"));

                col_x2.setCellValueFactory
                        (new PropertyValueFactory<>("x2"));

                col_x3.setCellValueFactory
                        (new PropertyValueFactory<>("x3"));


                col_x1.setVisible(true);
                col_x2.setVisible(true);
                col_x3.setVisible(true);
                col_x4.setVisible(false);
                col_x5.setVisible(false);
                col_x6.setVisible(false);

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




                col_x1.setVisible(true);
                col_x2.setVisible(true);
                col_x3.setVisible(true);
                col_x4.setVisible(true);
                col_x5.setVisible(false);
                col_x6.setVisible(false);
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

                col_x1.setVisible(true);
                col_x2.setVisible(true);
                col_x3.setVisible(true);
                col_x4.setVisible(true);
                col_x5.setVisible(true);
                col_x6.setVisible(false);
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
        switch (NBB)
        {
            case 1 :
                col_s1.setCellValueFactory
                        (new PropertyValueFactory<>("s1"));

                col_s1.setVisible(true);
                col_s2.setVisible(false);
                col_s3.setVisible(false);
                col_s4.setVisible(false);
                col_s5.setVisible(false);
                col_s6.setVisible(false);
                break;

            case 2 :

                col_s1.setCellValueFactory
                        (new PropertyValueFactory<>("s1"));

                col_s2.setCellValueFactory
                        (new PropertyValueFactory<>("s2"));

                col_s1.setVisible(true);
                col_s2.setVisible(true);
                col_s3.setVisible(false);
                col_s4.setVisible(false);
                col_s5.setVisible(false);
                col_s6.setVisible(false);

                break;

            case 3 :
                col_s1.setCellValueFactory
                        (new PropertyValueFactory<>("s1"));

                col_s2.setCellValueFactory
                        (new PropertyValueFactory<>("s2"));

                col_s3.setCellValueFactory
                        (new PropertyValueFactory<>("s3"));

                col_s1.setVisible(true);
                col_s2.setVisible(true);
                col_s3.setVisible(true);
                col_s4.setVisible(false);
                col_s5.setVisible(false);
                col_s6.setVisible(false);
                break;

            case 4:  col_s1.setCellValueFactory
                    (new PropertyValueFactory<>("s1"));

                col_s2.setCellValueFactory
                        (new PropertyValueFactory<>("s2"));

                col_s3.setCellValueFactory
                        (new PropertyValueFactory<>("s3"));

                col_s4.setCellValueFactory
                        (new PropertyValueFactory<>("s4"));

                col_s1.setVisible(true);
                col_s2.setVisible(true);
                col_s3.setVisible(true);
                col_s4.setVisible(true);
                col_s5.setVisible(false);
                col_s6.setVisible(false);
                break;

            case 5:
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

                col_s1.setVisible(true);
                col_s2.setVisible(true);
                col_s3.setVisible(true);
                col_s4.setVisible(true);
                col_s5.setVisible(true);
                col_s6.setVisible(false);
                break;

            case 6:
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

        col_update.setVisible(false);

        editableCols(colSize,NBB);
    }


    /**
     * makes each cell in a given table editable und stores their new data
     * @param colSize to determine size of columns
     *@param NBB to determine the columns which are needed for the slack variables
     */
    private void editableCols(int colSize, int NBB) {
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

        switch (NBB)
        {
            case 1 :
                col_s1.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s1.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS1(e.getNewValue());
                });
                break;

            case 2:
                col_s1.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s1.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS1(e.getNewValue());
                });

                col_s2.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s2.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS2(e.getNewValue());
                });
                break;

            case 3:
                col_s1.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s1.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS1(e.getNewValue());
                });

                col_s2.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s2.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS2(e.getNewValue());
                });


                col_s3.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s3.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS3(e.getNewValue());
                });
                break;
            case 4:
                col_s1.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s1.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS1(e.getNewValue());
                });

                col_s2.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s2.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS2(e.getNewValue());
                });


                col_s3.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s3.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS3(e.getNewValue());
                });

                col_s4.setCellFactory
                        (TextFieldTableCell.forTableColumn());
                col_s4.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS4(e.getNewValue());
                });
                break;
            case 5:
                col_s1.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s1.setOnEditCommit(e ->{
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS1(e.getNewValue());
                });

                col_s2.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s2.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS2(e.getNewValue());
                });


                col_s3.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s3.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS3(e.getNewValue());
                });

                col_s4.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s4.setOnEditCommit(e ->
                {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS4(e.getNewValue());
                });

                col_s5.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s5.setOnEditCommit(e -> {
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS5(e.getNewValue());
                });
                break;
            case 6:
                col_s1.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s1.setOnEditCommit(e ->{
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS1(e.getNewValue());
                });

                col_s2.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s2.setOnEditCommit(e ->{
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS2(e.getNewValue());
                });


                col_s3.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s3.setOnEditCommit(e ->{
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS3(e.getNewValue());
                });

                col_s4.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s4.setOnEditCommit(e ->{
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS4(e.getNewValue());
                });

                col_s5.setCellFactory
                        (TextFieldTableCell.forTableColumn());

                col_s5.setOnEditCommit(e ->{
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS5(e.getNewValue());
                });

                col_s6.setOnEditCommit(e ->{
                    e.getTableView().getItems().get(e.
                            getTablePosition().
                            getRow()).setS6(e.getNewValue());
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
    private void loadData(int rows, int columns, boolean run)
    {
        data_table= FXCollections.observableArrayList();
        boolean firstRun = run;

        for (int i = 0; i < rows; i++)
        {
            switch (columns)
            {
                case 1 :
                    data_table.add(new Variable(
                                    "0.00", "0.00","0.00"));

                    if (firstRun)
                    {
                        data_table.add(new Variable(
                                "0.00", "0.00","0.00"));
                        firstRun = false;
                    }

                    break;

                case 2 :
                    data_table.add(new Variable("0.00", "0.00", "0.00","0.00","0.00"));

                    if(firstRun)
                    {
                        data_table.add(new Variable("0.00", "0.00", "0.00","0.00","0.00"));
                        firstRun = false;
                    }
                    break;

                case 3 :
                    data_table.add(new Variable(
                            "0.00", "0.00","0.00", "0.00","0.00","0.00","0.00"));
                    if(firstRun) {
                        data_table.add(new Variable(
                                "0.00", "0.00", "0.00", "0.00","0.00","0.00","0.00"));
                        firstRun = false;
                    }
                        break;

                case 4 :
                    data_table.add(new Variable(
                        "0.00", "0.00","0.00", "0.00",  "0.00","0.00","0.00","0.00",
                            "0.00"));

                    if(firstRun) {
                        data_table.add(new Variable(
                                "0.00", "0.00","0.00", "0.00",  "0.00","0.00","0.00",
                                "0.00","0.00"));
                        firstRun = false;
                    }

                        break;

                case 5 :
                    data_table.add(new Variable(
                            "0.00", "0.00","0.00", "0.00","0.00","0.00",
                            "0.00","0.00","0.00","0.00","0.00" ));

                    if(firstRun) {
                        data_table.add(new Variable("0.00", "0.00","0.00", "0.00","0.00","0.00",
                                "0.00","0.00","0.00","0.00","0.00" ));
                        firstRun = false;
                    }
                    break;

                case 6 :
                    data_table.add(new Variable("0.00", "0.00", "0.00", "0.00",
                            "0.00","0.00", "0.00","0.00","0.00","0.00","0.00","0.00","0.00"));

                    if(firstRun)
                    {
                        data_table.add(new Variable("0.00", "0.00", "0.00", "0.00",
                                "0.00","0.00", "0.00","0.00","0.00","0.00","0.00",
                                "0.00","0.00"));
                        firstRun = false;
                    }
                    break;
            }

        }
        table_info.setItems(data_table);

    }

    /**
     * @param o is the object to check for floating numbers
     * @return an Object with instance of
     */
    public boolean isObjectFloat(Object o)
    {
        return o instanceof Float;
    }


    /**
     * checks for the correct float input
     * @param variables the table with the entries need to be checked
     * @return an boolean, if the input is a float number
     */
    public boolean checkInput(float[][] variables) {
        boolean inputValid = false;


        for (int i = 0; i < variables.length ; i++) {
            for (int j = 0; j < variables[i].length; j++) {
                if ( isObjectFloat( variables[i][j]))
                {
                    inputValid = true;
                }
                else {
                    return false;
                }
            }

        }
        return inputValid;
    }

    public  void fillData(String overgabe, int position){
        switch (position){
            case 1:
                output_1.setText(overgabe);
                break;
            case 2:
                output_2.setText(overgabe);
                break;
            case 3:
                output_3.setText(overgabe);
                break;
            case 4:
                output_4.setText(overgabe);
                break;
        }

    }


}