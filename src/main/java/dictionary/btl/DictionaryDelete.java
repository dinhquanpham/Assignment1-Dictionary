package dictionary.btl;

import dict.DictionaryManagement;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class DictionaryDelete {
    @FXML
    TextField targetWord;
    public void deleteWord() {
        String result = DictionaryManagement.getDictionaryLookup(targetWord.getText());
        if (result == "Tu nay khong ton tai") {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Từ này không có trong từ điển");
            alert.show();
        }else DictionaryManagement.dictionaryRemove(targetWord.getText());
    }
}
