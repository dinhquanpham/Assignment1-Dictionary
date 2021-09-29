import java.io.FileNotFoundException;

public class DictionaryCommandLine {
    public void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        DictionaryManagement.showAllWords();
    }

    public static void main(String[] args) throws FileNotFoundException {
        //DictionaryCommandLine newDictionary = new DictionaryCommandLine();
        //newDictionary.dictionaryBasic();
        DictionaryManagement.insertFromFile();
        DictionaryManagement.showAllWords();
    }
}
