package Gui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String [] args)
    {
     launch(args);
     //System.out.println();

    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Simplex");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("simplex.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        System.out.println("JavaFX version: " + System.getProperty("javafx.runtime.version"));
        stage.show();
    }
}
