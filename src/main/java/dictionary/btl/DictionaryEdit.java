package dictionary.btl;

import dict.DictionaryManagement;
import dict.Word;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class DictionaryEdit {
    @FXML
    TextField targetWord;
    @FXML
    TextField newMeaning;
    public void editWord() {
        String result = DictionaryManagement.getDictionaryLookup(targetWord.getText());
        if (result == "Tu nay khong ton tai") {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Từ này không tồn tại");
            alert.show();
        } else DictionaryManagement.setDictionaryEdit(new Word(targetWord.getText(), newMeaning.getText()));
    }
}
