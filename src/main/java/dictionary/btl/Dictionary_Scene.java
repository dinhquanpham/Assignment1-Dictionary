package dictionary.btl;

import dict.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Polygon;

import java.io.FileNotFoundException;

public class Dictionary_Scene extends DictionaryManagement {
    @FXML
    private TextField DictTextFeild;
    @FXML
    private Button SearchButton;
    private Polygon Circle;
    private double x;
    private double y;
    @FXML
    public void InsertFormFile() throws FileNotFoundException {
        DictionaryManagement.insertFromFile();
    }
    public void SearchFunction() {
        //DictionaryManagement.dictionarySearch();
    }
    public void ShowAllWord() {
        DictionaryManagement.showAllWords();
    }

}
