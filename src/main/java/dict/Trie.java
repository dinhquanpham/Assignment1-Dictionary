package dict;

import java.util.Set;

public class Trie {
    private TrieNode root = new TrieNode();

    /**
     * Them tu.
     */
    public void add(Word addWord) {
        TrieNode current = root;
        for (char c : addWord.getWord_target().toCharArray()) {
            current = current.getChildren().computeIfAbsent(c, newNode -> new TrieNode());
        }
        current.setIsWord(true);
        current.setContent(addWord);
    }

    /**
     * Tra tu.
     */
    public String search(String searchWord) {
        TrieNode current = root;
        for (char c : searchWord.toCharArray()) {
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
        delete(root, deleteWord, 0);
    }

    /**
     * In tu dien.
     */
    private int cnt = 0;
    private void print(TrieNode current) {
        if (current.getIsWord()) {
            cnt++;
            System.out.printf("%d\t%s\t", cnt, current.getContent().getWord_target());
            System.out.printf("%s\n", current.getContent().getWord_explain());
        }
        Set<Character> children = current.getChildren().keySet();
        for (char c : children) {
            print(current.getChildren().get(c));
        }
    }

    public void print() {
        print(root);
    }
}
