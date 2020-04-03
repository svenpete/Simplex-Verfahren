package Gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    ObservableList<Integer> constraints = FXCollections.observableArrayList(1,2,3,4,5,6);
    ObservableList<Integer> variables = FXCollections.observableArrayList(1,2,3,4,5,6);

    @FXML
    private ComboBox NB;

    @FXML
    private ComboBox Variablen;

    @FXML
    private Button sRow;

    @FXML
    private Button sColumn;

    @FXML
    private TableView<Gui.Variablen> table;

    @FXML
    void changeColumn(ActionEvent event)
    {
        table.getColumns().clear();
        int number = checkVariablesInput();

        TableColumn firstColumn = new TableColumn("Nebenbedingungen/Variabeln");
        TableColumn secondColumn = new TableColumn("x1");
        TableColumn thirdColumn = new TableColumn("x2");
        TableColumn fourthColumn = new TableColumn("x3");
        TableColumn fifthColumn = new TableColumn("x4");
        TableColumn sixthColumn = new TableColumn("x5");
        TableColumn seventhColumn = new TableColumn("x6");



        switch (number)
        {
            case 1:
                table.getColumns().addAll(firstColumn,secondColumn);
                break;


            case 2:
                table.getColumns().addAll(firstColumn,secondColumn,
                        thirdColumn);
                break;


            case 3:
                table.getColumns().addAll(firstColumn,secondColumn,
                        thirdColumn,fourthColumn);
                break;

            case 4:
                table.getColumns().addAll(firstColumn,secondColumn,
                        thirdColumn,fourthColumn,fifthColumn);
                break;

            case 5:
                table.getColumns().addAll(firstColumn,secondColumn,
                        thirdColumn,fourthColumn,
                        fifthColumn,sixthColumn);
                break;

            case 6:
                table.getColumns().addAll(firstColumn,secondColumn,
                        thirdColumn,fourthColumn,
                        fifthColumn,sixthColumn,seventhColumn);
                break;

        }
    }

        private ObservableList<Variablen> vb = FXCollections.observableArrayList();


    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        NB.setValue(1);
        NB.setItems(constraints);

        Variablen.setValue(1);
        Variablen.setItems(variables);

        vb.add(new Variablen("y2"));
        table.setItems(vb);
    }




    @FXML
    private int checkVariablesInput()
    {
      Integer number = (Integer) Variablen.getValue();
      return number;
    }

}
