package leetcode.challenge.may;

/**
 Week2 May14
 Implement a trie with insert, search, and startsWith methods.

 Example:

 Trie trie = new Trie();

 trie.insert("apple");
 trie.search("apple");   // returns true
 trie.search("app");     // returns false
 trie.startsWith("app"); // returns true
 trie.insert("app");
 trie.search("app");     // returns true

 Note:
    1. You may assume that all inputs consist of lowercase letters a-z.
    2. All inputs are guaranteed to be non-empty strings.

 */
public class C14_ImplementTrie_PrefixTree {
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("rockstar");
        boolean param_2 = obj.search("rockstar");
        boolean param_3 = obj.startsWith("rock");
    }
}

class Trie {

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
