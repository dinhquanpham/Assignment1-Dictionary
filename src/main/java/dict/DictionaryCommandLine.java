package dict;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandLine {
    /**
     * Tu dien don gian.
     */
    public void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        DictionaryManagement.showAllWords();
    }

    /**
     * Tu dien nang cao.
     */
    public void dictionaryAdvanced() throws FileNotFoundException, IOException{
        DictionaryManagement.insertFromFile();
        DictionaryManagement.showAllWords();
        Scanner stdin = new Scanner(System.in);
        String inputWord = stdin.nextLine();
        DictionaryManagement.dictionarySearch(inputWord);
        DictionaryManagement.resetDictionaryData();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        DictionaryCommandLine newDictionary = new DictionaryCommandLine();
        newDictionary.dictionaryAdvanced();
    }
}
