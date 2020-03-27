package Gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private TextField NB;

    @FXML
    private TextField Variablen;

    @FXML
    private Button sRow;

    @FXML
    private Button sColumn;

    @FXML
    private TableView<?> table;

    @FXML
    void changeColumn(ActionEvent event)
    {
        checkInput(Variablen.getCharacters());
        TableColumn firstColumn = new TableColumn("x1");
        TableColumn secondColumn = new TableColumn("x2");
        table.getColumns().addAll(firstColumn, secondColumn);
    }
    private static int checkInput(CharSequence input)
    {
        Integer number = Integer.parseInt(input.toString());        //Variante von Consti
        //Integer number = Integer.parseInt(input,0,input.length(),10); Variante von Sven
        return number;
    }


}
