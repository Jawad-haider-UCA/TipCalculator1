package MiniBrowser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MiniBrowser extends Application {

    public void start(Stage stage) throws Exception {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("MiniBrowser.fxml"));
        stage.setTitle("MiniBrowser");
        stage.setScene(new Scene(root));
        stage.show();

    }

    public static void main(String[] args) { launch(args); }
}