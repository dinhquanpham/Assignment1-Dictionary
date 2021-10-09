package dictionary.btl;

import dict.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Polygon;

import java.io.FileNotFoundException;

public class Dictionary_Scene  {
    @FXML
    private TextField SearchTextField;
    @FXML
    public void InsertFormFile() throws FileNotFoundException {
    }
    public void SearchFunction() {
        //DictionaryManagement.dictionarySearch();
    }
    public void getSearch(ActionEvent event) {
        String SearchWord = SearchTextField.getText();
        System.out.print("SearchWord");
    }
    public void ShowAllWord() throws FileNotFoundException {
        DictionaryManagement.insertFromFile();
        DictionaryManagement.showAllWords();
    }

}
