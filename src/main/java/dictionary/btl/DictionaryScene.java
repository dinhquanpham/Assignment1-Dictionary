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
import java.util.Optional;

public class DictionaryScene extends DictionaryManagement {
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
     * Edit.
     */
    @FXML
    public void HandleAdd() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/dictionary/btl/DictionaryAdd.fxml"));
        Parent root = loader.load();
        Stage window = new Stage();
        window.setScene(new Scene(root, 500, 250));
        window.setTitle("Add");
        window.show();
    }
    @FXML
    public void HandleDelete() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/dictionary/btl/DictionaryDelete.fxml"));
        Parent root = loader.load();
        Stage window = new Stage();
        window.setScene(new Scene(root, 500, 250));
        window.setTitle("Delete");
        window.show();
    }
    @FXML
    public void HandleEdit() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/dictionary/btl/DictionaryEdit.fxml"));
        Parent root = loader.load();
        Stage window = new Stage();
        window.setScene(new Scene(root, 500, 250));
        window.setTitle("Edit");
        window.show();
    }

    /**
     * About
     */
    @FXML
    public void HandleAbout() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/dictionary/btl/DictionaryAbout.fxml"));
        Parent root = loader.load();
        Stage window = new Stage();
        window.setScene(new Scene(root, 500, 400));
        window.setTitle("About");
        window.show();
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
    private TextField SearchWord;
    @FXML
    private VBox PrintWord;
    @FXML
    public void SearchButton() {
        PrintWord.getChildren().clear();
        String currentWord = SearchWord.getText();
        Label label = new Label();
        String result = DictionaryManagement.getDictionaryLookup(currentWord);
        if (result == "Tu nay khong ton tai") {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Từ này không tồn tại");
            alert.show();
        } else {
            label.setText(currentWord + "\n" + "\t" + result);
            PrintWord.getChildren().add(label);
        }
    }

    @FXML
    private VBox SearchList;
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
