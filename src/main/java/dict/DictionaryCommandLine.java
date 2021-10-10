package dict;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandLine {
    /**
     * Tu dien don gian.
     */
    public static void dictionaryBasic() {
        DictionaryManagement.showAllWords();
    }

    /**
     * Tu dien nang cao.
     */
    public static void dictionaryAdvanced() throws FileNotFoundException, IOException{
        DictionaryManagement.insertFromFile();
        //DictionaryManagement.showAllWords();
        DictionaryManagement.dictionaryExportToFile();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        DictionaryCommandLine.dictionaryAdvanced();
    }
}
