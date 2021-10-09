package dict;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;

public class Trie {
    private TrieNode root = new TrieNode();

    /**
     * Them tu.
     */
    public void add(Word addWord) {
        TrieNode current = root;
        for (char c : addWord.getWord_target().toLowerCase().toCharArray()) {
            current = current.getChildren().computeIfAbsent(c, newNode -> new TrieNode());
        }
        current.setIsWord(true);
        current.setContent(addWord);
    }

    /**
     * Tra tu.
     */
    public String LookUp(String searchWord) {
        TrieNode current = root;
        for (char c : searchWord.toLowerCase().toCharArray()) {
            TrieNode node = current.getChildren().get(c);
            if (node == null) {
                return "Tu nay khong ton tai";
            }
            current = node;
        }
        if (current.getIsWord()) {
            return current.getContent().getWord_explain();
        } else {
            return "Tu nay khong ton tai";
        }
    }

    /**
     * Xoa tu.
     */
    private boolean delete(TrieNode current, String deleteWord, int index) {
        if (index == deleteWord.length()) {
            if (!current.getIsWord()) {
                return false;
            }
            current.setIsWord(false);
            return current.getChildren().isEmpty();
        }
        char c = deleteWord.charAt(index);
        TrieNode node = current.getChildren().get(c);
        if (node == null) {
            return false;
        }
        boolean shouldRemoveCurrentNode = delete(node, deleteWord, index + 1) && !node.getIsWord();
        if (shouldRemoveCurrentNode) {
            current.getChildren().remove(c);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    public void delete(String deleteWord) {
        delete(root, deleteWord.toLowerCase(), 0);
    }

    /**
     * Toan bo tu dien.
     */
    private ArrayList<Word> resultWords = new ArrayList();
    private void get(TrieNode current) {
        if (current.getIsWord()) {
            resultWords.add(current.getContent());
        }
        SortedSet<Character> children = new TreeSet<>(current.getChildren().keySet());
        for (char c : children) {
            get(current.getChildren().get(c));
        }
    }

    public ArrayList<Word> getArrayListFromTrie() {
        resultWords = new ArrayList();
        get(root);
        if (resultWords.size() == 0) {
            return null;
        }
        return resultWords;
    }

    /**
     * Tra cac tu tien to.
     */
    private ArrayList<String> resultWords1 = new ArrayList();
    private void getDictionarySearch(TrieNode current) {
        if (current.getIsWord()) {
            resultWords1.add(current.getContent().getWord_target());
        }
        SortedSet<Character> children = new TreeSet<>(current.getChildren().keySet());
        for (char c : children) {
            getDictionarySearch(current.getChildren().get(c));
        }
    }

    public ArrayList<String> getDictionarySearch(String targetWord) {
        resultWords1 = new ArrayList();
        TrieNode current = root;
        for (char c : targetWord.toLowerCase().toCharArray()) {
            TrieNode node = current.getChildren().get(c);
            if (node == null) {
                return resultWords1;
            }
            current = node;
        }
        getDictionarySearch(current);
        if (resultWords1.size() == 0) {
            return null;
        }
        return resultWords1;
    }
}
