package dictionary.btl;

import dict.DictionaryCommandLine;
import dict.DictionaryManagement;
import dict.Word;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

    @FXML
    Button addButton;
    @FXML
    Button backButton;
    @FXML
    Button addBackButton;
    @FXML
    MenuItem addWord;
    @FXML
    TextArea newWordTarget;
    @FXML
    TextArea newWordExplain;
    public void HandleAddButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/dictionary/btl/AddWord.fxml"));
        Stage window = (Stage) addButton.getScene().getWindow();
        window.setScene(new Scene(root, 500, 350));
        EventHandler<ActionEvent> event = e -> {
            dictionary.add(new Word(newWordTarget.getText(), newWordExplain.getText()));
            System.out.println(newWordTarget.getText() + "      " + newWordExplain.getText());
        };
        window.show();
    }
    public void HandleBackButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/dictionary/btl/DictionaryScene.fxml"));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 900, 625));
        window.show();
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
