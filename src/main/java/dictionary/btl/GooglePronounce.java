package dictionary.btl;

import javazoom.jl.player.Player;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GooglePronounce {
    public static void pronounce(String text) throws Exception {
        String api = "http://translate.google.com/translate_tts?ie=UTF-8&tl="+ "en" + "&client=tw-ob&q=" +
                URLEncoder.encode(text, StandardCharsets.UTF_8);
        URL url = new URL(api);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        InputStream audio = con.getInputStream();
        new Player(audio).play();
        con.disconnect();
    }
}