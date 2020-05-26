package trie;

import java.util.HashMap;
import java.util.Map;

/**
 https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1052/
 */
public class AddAndSearchWord {
    public static void main(String[] args) {
        /*
        Input:
        ["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
        [[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
        Output:   [null,null,null,null,null,false,false,null,false,true,false,false,false,false]
        Expected: [null,null,null,null,null,false,false,null,true,true,false,false,true,false]

         */


        WordDictionary wd = new WordDictionary();
        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.addWord("add");
        System.out.println(wd.search("a"));
        System.out.println(wd.search(".at"));
        wd.addWord("bat");
        System.out.println(wd.search(".at"));
        System.out.println(wd.search("an."));
        System.out.println(wd.search("a.d."));
        System.out.println(wd.search("b."));
        System.out.println(wd.search("a.d"));
        System.out.println(wd.search("."));

    }

}

class WordDictionary {

    TrieNode root;

    class TrieNode {
        Map<Character, TrieNode> map;
        boolean isTerminating;

        TrieNode() {
            map = new HashMap<>();
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] chars = word.toCharArray();
        TrieNode current = root;
        for(char ch : chars) {
            current.map.putIfAbsent(ch, new TrieNode());
            current = current.map.get(ch);
        }
        current.isTerminating = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        return searchRec(root, chars, 0);
    }

    private boolean searchRec(TrieNode node, char[] chars, int index) {
        if(index == chars.length)
            return node.isTerminating;

        char ch = chars[index];
        if(ch == '.') {
            boolean result = false;
            for(char letter : node.map.keySet()) {
                result =  result || searchRec(node.map.get(letter), chars, index+1);
            }
            return result;
        } else {
            if(node.map.containsKey(ch)) {
                return searchRec(node.map.get(ch), chars, index+1);
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

