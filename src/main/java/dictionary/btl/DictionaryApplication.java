package dictionary.btl;

import dict.DictionaryManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DictionaryApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DictionaryManagement.insertFromFile();
        Parent root = FXMLLoader.load(getClass().getResource("/dictionary/btl/DictionaryScene.fxml"));
        Scene scene = new Scene(root, 900, 625);
        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}