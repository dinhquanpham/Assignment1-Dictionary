import java.io.FileNotFoundException;
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
    public void dictionaryAdvanced() throws FileNotFoundException {
        DictionaryManagement.insertFromFile();
        DictionaryManagement.showAllWords();
        Scanner stdin = new Scanner(System.in);
        String inputWord = stdin.nextLine();
        DictionaryManagement.dictionaryLookup(inputWord);
    }

    public static void main(String[] args) throws FileNotFoundException {
        DictionaryCommandLine newDictionary = new DictionaryCommandLine();
        newDictionary.dictionaryAdvanced();
    }
}
