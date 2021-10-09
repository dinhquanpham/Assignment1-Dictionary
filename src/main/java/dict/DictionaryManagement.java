package dict;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DictionaryManagement {
    public static Trie dictionary = new Trie();

    /**
     * Nhap tu moi tu CommandLine vao tu dien.
     */
    public static void insertFromCommandline() {
        Scanner stdin = new Scanner(System.in);
        String word_target = stdin.nextLine();
        String word_explain = stdin.nextLine();
        Word newWord = new Word(word_target, word_explain);
        dictionary.add(newWord);
    }

    /**
     * Nhap du lieu tu dien tu tep dictionaries.txt.
     */
    public static void insertFromFile() throws FileNotFoundException {
        String projectAddress = System.getProperty("user.dir");
        String dictionaryAddress = projectAddress + "\\data\\english-vietnamese.txt";
        FileInputStream fileInputStream = new FileInputStream(dictionaryAddress);
        Scanner stdin = new Scanner(fileInputStream);
        try {
            while (stdin.hasNextLine()) {
                String line = stdin.nextLine();
                String reglex = "\t";
                String[] strArr = line.split(reglex,2);
                String word_target = strArr[0];
                String word_explain = strArr[1];
                Word newWord = new Word(word_target, word_explain);
                dictionary.add(newWord);
            }
        } finally {
            try {
                stdin.close();
                fileInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(DictionaryManagement.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Hien thi toan bo tu dien.
     */
    public static void showAllWords() {
        ArrayList<Word> words = dictionary.getArrayListFromTrie();
        System.out.printf("No\t|English\t|Vietnamese\n");
        int cnt = 0;
        for (Word word : words) {
            cnt++;
            String word_target = word.getWord_target();
            String word_explain = word.getWord_explain();
            System.out.printf("%d\t%s   ", cnt, word_target);
            System.out.printf("%s\n",word_explain.replace("#","\n"));
        }
    }

    /**
     * Tra ve gia tri tra cuu tu dien.
     */
    public static String getDictionaryLookup(String lookupWord) {
        String Word = dictionary.LookUp(lookupWord).replace("#","\n");
        return Word;
    }

    /**
     * Tra cuu tu dien
     */
    public static void dictionaryLookup(String lookupWord) {

//        int found = 0;
//        for (Word word : dictionary) {
//            String curWord = word.getWord_target();
//            if (lookupWord.equalsIgnoreCase(curWord)) {
//                System.out.println(lookupWord + " mean: " + word.getWord_explain());
//                found = 1;
//                break;
//            }
//        }
//        if (found == 0) {
//            System.out.println("Tu nay khong co trong tu dien");
//        }
        System.out.println(getDictionaryLookup(lookupWord));
    }

    /**
     * Them tu moi vao tu dien.
     */
    public static void dictionaryAdd(Word newWord) {
        dictionary.add(newWord);
    }

    /**
     * Xoa du lieu tu dien.
     */
    public static void dictionaryRemove(String removeWord) {
        dictionary.delete(removeWord);
    }

    /**
     * Tim kiem tu tien to.
     */
    public static void dictionarySearch(String targetWord) {
        ArrayList<String> searchList = dictionary.getDictionarySearch(targetWord);
        for (String word : searchList) {
            System.out.println(word);
        }
    }

    /**
     * Lay du lieu tu dictionarySearch
     */
    public static ArrayList<String> getDictionarySearch(String targetWord) {
        return dictionary.getDictionarySearch(targetWord);
    }
    /**
     * Chinh sua lai du lieu tu dien trong file txt
     */
    public static void dictionaryExportToFile() throws IOException {
        String projectAddress = System.getProperty("user.dir");
        String dictionaryAddress = projectAddress + "\\data\\dictionaries.txt";
        FileWriter fileWriter = new FileWriter(dictionaryAddress);
        ArrayList<Word> words = dictionary.getArrayListFromTrie();
        for (Word word : words) {
            fileWriter.write(word.getWord_target() + "\t" + word.getWord_explain() + '\n');
        }
        fileWriter.close();
    }
}
