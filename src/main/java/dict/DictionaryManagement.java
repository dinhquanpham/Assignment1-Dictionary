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
        System.out.printf("No\t|English\t|Vietnamese\n");
        int cnt = 0;
        for (Word word : dictionary) {
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
        int found = 0;
        String ans = "";
        for (Word word : dictionary) {
            String curWord = word.getWord_target();
            if (lookupWord.equalsIgnoreCase(curWord)) {
                ans = lookupWord + " mean: " + word.getWord_explain().replace("#","\n");
                found = 1;
                break;
            }
        }
        if (found == 0) {

            return ("Tu nay khong co trong tu dien");
        }
        return ans;
    }

    /**
     * Tra cuu tu dien
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
     * Them tu moi vao tu dien.
     */
        public static void dictionaryAdd(Word newWord) {
        String word_target = newWord.getWord_target();
        String word_explain = newWord.getWord_explain();
        int index = -1;
        for (int i = 0; i < dictionary.size() - 1; i++) {
            String prevWord = dictionary.get(i).getWord_target();
            String nextWord = dictionary.get(i + 1).getWord_target();
            if (word_target.compareTo(prevWord) > 0 && word_target.compareTo(nextWord) < 0) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            dictionary.add(index, newWord);
        } else {
            if (dictionary.size() == 0)return;
            if (word_target.compareTo(dictionary.get(0).getWord_target()) < 0) {
                dictionary.add(0, newWord);
            } else {
                dictionary.add(newWord);
            }
        }
    }

    /**
     * Xoa du lieu tu dien.
     */
    public static void dictionaryRemove(String removeWord) {
        int index = -1;
        for (int i = 0; i < dictionary.size(); i++) {
            if (removeWord.equalsIgnoreCase(dictionary.get(i).getWord_target())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            dictionary.remove(index);
        } else {
            System.out.println("Tu nay khong co trong tu dien");
        }
    }

    /**
     * Tim kiem tu tien to.
     */
    public static void dictionarySearch(String targetWord) {
        int found_targetWord = 0;
        for (Word word :dictionary) {
            if (word.getWord_target().startsWith(targetWord)) {
                found_targetWord = 1;
                System.out.println(word.getWord_target());
            }
        }
        if (found_targetWord == 0) {
            System.out.printf("Khong co tu de tim kiem" + "\n");
        }
    }

    /**
     * Lay du lieu tu dictionarySearch
     */
    public static ArrayList<String> getDictionarySearch(String targetWord) {
        int found_targetWord = 0;
        ArrayList<String> searchList = new ArrayList<>();
        for (Word word :dictionary) {
            if (word.getWord_target().startsWith(targetWord)) {
                found_targetWord = 1;
                String word_target = word.getWord_target();
                searchList.add(word_target);
            }
        }
        return searchList;
    }
    /**
     * Chinh sua lai du lieu tu dien trong file txt
     */
    public static void resetDictionaryData() throws IOException {
        String projectAddress = System.getProperty("user.dir");
        String dictionaryAddress = projectAddress + "\\data\\dictionaries.txt";
        FileWriter fileWriter = new FileWriter(dictionaryAddress);
        for (Word word : dictionary) {
            fileWriter.write(word.getWord_target() + "\t" + word.getWord_explain() + '\n');
        }
        fileWriter.close();
    }
}
