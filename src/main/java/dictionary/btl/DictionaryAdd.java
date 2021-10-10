package dictionary.btl;

import dict.DictionaryCommandLine;
import dict.DictionaryManagement;
import dict.Word;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DictionaryAdd {
    @FXML
    TextField newWordTarget;
    @FXML
    TextField newWordExplain;
    public void getNewWord(){
        DictionaryManagement.dictionaryAdd(new Word(newWordTarget.getText(), newWordExplain.getText()));
    }
}
