package dictionary.btl;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Handler;

public class DictionaryApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/dictionary/btl/Dictionary_Scene.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Dictionary-Offline");
        stage.setScene(scene);
        stage.show();
    }

    public void handler(ActionEvent event) {

    }

    public static void main(String[] args) {
        launch();
    }
}