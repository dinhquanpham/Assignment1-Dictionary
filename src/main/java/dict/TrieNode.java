package dict;

import java.util.HashMap;

public class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap<>();
    private boolean isWord;
    private Word content;

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean getIsWord() {
        return isWord;
    }

    public void setIsWord(boolean word) {
        isWord = word;
    }

    public Word getContent() {
        return content;
    }

    public void setContent(Word content) {
        this.content = content;
    }
}
