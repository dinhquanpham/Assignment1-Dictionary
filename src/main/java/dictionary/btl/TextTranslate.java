package dictionary.btl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javazoom.jl.player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TextTranslate {
    @FXML
    private TextField targetText;
    @FXML
    private VBox explainText;

    public static String translate(String text) throws IOException {
        String urlStr = "https://script.google.com/macros/s/AKfycbwHsg9Ywpg25EwswiLFGGSCVKaN3eNr8QxsGrdDe9ofcfZIZds/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + "vi" +
                "&source=" + "en";
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
    public void PrintTranslateText (ActionEvent event) throws IOException {
        explainText.getChildren().clear();
        String resultText = translate(targetText.getText());
        Label label = new Label();
        label.setText(resultText);
        explainText.getChildren().add(label);
    }

//    public static void pronounceText(String text) throws Exception {
//        String api = "http://translate.google.com/translate_tts?ie=UTF-8&tl="+ "vi" + "&client=tw-ob&q=" +
//                URLEncoder.encode(text, StandardCharsets.UTF_8);
//        URL url = new URL(api);
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        InputStream audio = con.getInputStream();
//        new Player(audio).play();
//        con.disconnect();
//    }

}
