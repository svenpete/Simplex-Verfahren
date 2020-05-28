package SimplexFunktioniert;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("View/table.fxml"));
        stage.setTitle("TestEditableTable.Model.Simplex-Verfahren");
        stage.setScene(new Scene(root, 1200 ,800));
        stage.show();

    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
