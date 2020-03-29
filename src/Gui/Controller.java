package Gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


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
        table.getColumns().clear();
        int number = checkInput(Variablen.getCharacters());
        TableColumn firstColumn     =   new TableColumn("x1");
        TableColumn secondColumn    =   new TableColumn("x2");
        TableColumn thirdColumn     =   new TableColumn("x3");
        TableColumn fourthColumn    =   new TableColumn("x4");

        switch (number)
        {
            case 1:
                table.getColumns().addAll(firstColumn);
                break;

                case 2:
                table.getColumns().addAll(firstColumn,secondColumn);
                break;

            case 3:
                table.getColumns().addAll(firstColumn,secondColumn,thirdColumn);
                break;

            case 4:
                table.getColumns().addAll(firstColumn,secondColumn,thirdColumn,fourthColumn);
                break;
        }
    }

    private static int checkInput(CharSequence input)
    {
        Integer number = Integer.parseInt(input.toString());        //Variante von Consti
        //Integer number = Integer.parseInt(input,0,input.length(),10); Variante von Sven
        return number;
    }


}
