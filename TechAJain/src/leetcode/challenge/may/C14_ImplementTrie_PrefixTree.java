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

class Trie {
    Trie[] root;
    boolean[] isTerminal;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Trie[26];
        isTerminal = new boolean[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Trie temp = this;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';

            if(i == chars.length-1) {
                temp.isTerminal[index] = true;
                break;
            }

            if(temp.root[index] == null)
                temp.root[index] = new Trie();
            temp = temp.root[index];
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Trie temp = this;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';

            if(i == chars.length-1) {
                return temp.isTerminal[index];
            }

            if(temp.root[index] != null)
                temp = temp.root[index];
            else {
                return false;
            }
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Trie temp = this;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';

            if(i == chars.length-1) {
                return temp.root[index] != null || temp.isTerminal[index];
            }

            if(temp.root[index] != null)
                temp = temp.root[index];
            else {
                return false;
            }
        }
        return true;
    }
}

public class C14_ImplementTrie_PrefixTree {
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("rockstar");
        System.out.println(obj.search("rockstar"));
        System.out.println(obj.startsWith("rock"));
        obj.insert("rockys");
        System.out.println(obj.startsWith("rock"));         // true
        System.out.println(obj.startsWith("rocky"));        // true
        System.out.println(obj.search("rockstar"));   // true
        System.out.println(obj.search("rockys"));     // true
        System.out.println(obj.search("rock"));       // false

        System.out.println("*********");

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}