package dictionary.btl;

import dict.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Dictionary_Scene extends DictionaryManagement {
    @FXML
    private TextField SearchWord;
    @FXML
    private VBox PrintWord;
    @FXML
    private VBox SearchList;
    @FXML
    public void InsertFormFile() throws FileNotFoundException {
        DictionaryManagement.insertFromFile();
    }
//    public void LookUpFunction(ActionEvent event) {
//        Label label1 = new Label();
//        String LookUpKey = SearchWord.getText();
//        String result = DictionaryManagement.getDictionaryLookup(LookUpKey);
//        label1.setText(result);
//        PrintWord.getChildren().add(label1);
//    }
    @FXML
    public void LookUpFunction() {
        SearchList.getChildren().clear();
        ArrayList<String> searchListArray = DictionaryManagement.getDictionarySearch(SearchWord.getText());
        for (int i = 0; i < 30; i++) {
            Button button = new Button();
            button.setText(searchListArray.get(i));
            String currentWord = searchListArray.get(i);
            EventHandler<ActionEvent> event = e -> {
                PrintWord.getChildren().clear();
                Label label1 = new Label();
                String LookUpKey = currentWord;
                String result = DictionaryManagement.getDictionaryLookup(LookUpKey);
                label1.setText(result);
                PrintWord.getChildren().add(label1);
            };
            button.setOnAction(event);
            SearchList.getChildren().add(button);
        }

    }
    public void ShowAllWord() throws FileNotFoundException{
        DictionaryManagement.showAllWords();
    }

}
