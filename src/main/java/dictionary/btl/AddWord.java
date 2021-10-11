package dictionary.btl;

import dict.DictionaryManagement;
import dict.Word;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AddWord extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage addStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/dictionary/btl/AddWord.fxml"));
        Scene scene = new Scene(root, 900, 625);
        addStage.setTitle("Add Word");
        addStage.setScene(scene);
        addStage.show();
    }
}
