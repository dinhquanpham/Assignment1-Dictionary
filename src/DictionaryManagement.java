import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DictionaryManagement {
    public static ArrayList<Word> dictionary = new ArrayList();

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
        String dictionaryAddress = projectAddress + "\\data\\dictionaries.txt";
        FileInputStream fileInputStream = new FileInputStream(dictionaryAddress);
        Scanner stdin = new Scanner(fileInputStream);
        try {
            while (stdin.hasNextLine()) {
                String line = stdin.nextLine();
                String[] strArr = line.split("\t");
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
        System.out.printf("No\t|English\t|Vietnamese\n");
        int cnt = 0;
        for (Word word : dictionary) {
            cnt++;
            String word_target = word.getWord_target();
            String word_explain = word.getWord_explain();
            System.out.printf("%d\t|%s\t|%s\n", cnt, word_target, word_explain);
        }
    }

    /**
     * Tra cuu tu dien.
     */
    public static void dictionaryLookup(String lookupWord) {
        int found = 0;
        for (Word word : dictionary) {
            String curWord = word.getWord_target();
            if (lookupWord.equalsIgnoreCase(curWord)) {
                System.out.println(lookupWord + " mean: " + word.getWord_explain());
                found = 1;
                break;
            }
        }
        if (found == 0) {
            System.out.println("Tu nay khong co trong tu dien");
        }
    }

    /**
     * Xoa du lieu tu dien = dong lenh.
     */
    public static void eraseWord(String ans) {
        int index = -1;
        for (Word word : dictionary) {

        }
    }
}
