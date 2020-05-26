package trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1053/
 */
public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = buildTrie(dict);
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            String prefix = findRoot(root, words[i]);
            result.append(prefix.equals("") ? words[i] : prefix).append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private String findRoot(TrieNode root, String word) {
        char[] chars = word.toCharArray();
        TrieNode current = root;
        StringBuilder prefix = new StringBuilder();
        for(char ch : chars) {
            if(current.children.containsKey(ch)) {
                prefix.append(ch);
            } else {
                return "";
            }
            current = current.children.get(ch);
            if(current.isTerminating) {
                return prefix.toString();
            }
        }
        return "";
    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
        for(String word : dict) {
            addWordToTrie(root, word);
        }
        return root;
    }

    private void addWordToTrie(TrieNode root, String word) {
        TrieNode current = root;

        for(char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isTerminating = true;
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isTerminating;
        TrieNode() {
            children = new HashMap();
        }
    }
}
