package dictionary.btl;

import dict.DictionaryCommandLine;
import dict.DictionaryManagement;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class DictionaryScene extends DictionaryManagement {
    @FXML
    private TextField SearchWord;
    @FXML
    private VBox PrintWord;
    @FXML
    private VBox SearchList;

    /**
     * File menu
     */
    @FXML
    public void InsertFormFile(ActionEvent event) throws FileNotFoundException {
        DictionaryManagement.insertFromFile();
    }
    @FXML
    public void ExportToFile(ActionEvent event) throws IOException {
        DictionaryManagement.dictionaryExportToFile();
    }
    @FXML
    public void Exit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    /**
     * Commandline.
     */
    @FXML
    public void DictionaryBasic(ActionEvent event) {
        DictionaryCommandLine.dictionaryBasic();
    }
    @FXML
    public void DictionaryAvanced(ActionEvent event) throws FileNotFoundException, IOException{
        DictionaryCommandLine.dictionaryAdvanced();
    }

    /**
     * Xu ly man hinh giao dien
     */
    @FXML
    public void SearchButton() {
        PrintWord.getChildren().clear();
        String currentWord = SearchWord.getText();
        Label label = new Label();
        label.setText(DictionaryManagement.getDictionaryLookup(currentWord));
        PrintWord.getChildren().add(label);
    }

    @FXML
    public void LookUpFunction() {
        SearchList.getChildren().clear();
        ArrayList<String> searchListArray = DictionaryManagement.getDictionarySearch(SearchWord.getText());

        int arraySize = Math.min(40, searchListArray.size());

        for (int i = 0; i < arraySize; i++) {
            Button button = new Button();
            button.setText(searchListArray.get(i));
            String currentWord = searchListArray.get(i);
            EventHandler<ActionEvent> event = e -> {
                PrintWord.getChildren().clear();
                Label label = new Label();
                String result = DictionaryManagement.getDictionaryLookup(currentWord);
                label.setText(currentWord + "\n" + "\t" + result);
                PrintWord.getChildren().add(label);
            };
            button.setOnAction(event);
            SearchList.getChildren().add(button);
        }

    }
}
