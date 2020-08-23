package leetcode.challenge.august;

import java.util.ArrayList;
import java.util.List;

/**
 1032. Stream of Characters
 https://leetcode.com/problems/stream-of-characters/

 Implement the StreamChecker class as follows:

 StreamChecker(words): Constructor, init the data structure with the given words.
 query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.

 Example:
     StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
     streamChecker.query('a');          // return false
     streamChecker.query('b');          // return false
     streamChecker.query('c');          // return false
     streamChecker.query('d');          // return true, because 'cd' is in the wordlist
     streamChecker.query('e');          // return false
     streamChecker.query('f');          // return true, because 'f' is in the wordlist
     streamChecker.query('g');          // return false
     streamChecker.query('h');          // return false
     streamChecker.query('i');          // return false
     streamChecker.query('j');          // return false
     streamChecker.query('k');          // return false
     streamChecker.query('l');          // return true, because 'kl' is in the wordlist

 Note:
     1 <= words.length <= 2000
     1 <= words[i].length <= 2000
     Words will only consist of lowercase English letters.
     Queries will only consist of lowercase English letters.
     The number of queries is at most 40000.
 */
public class AG23_StreamOfCharacters {
    static class StreamChecker {

        Trie root;
        List<Character> letters;

        class Trie {
            Trie[] map;
            boolean isLeaf;

            public Trie() {
                map = new Trie[26];
                isLeaf = false;         // not required, just being explicit
            }

            private void addWord(String word) {
                Trie current = this;
                char[] chars = word.toCharArray();
                int len = chars.length;
                for(int i = len - 1; i >= 0; i--) {
                    if(current.map[chars[i] - 'a'] == null) {
                        current.map[chars[i] - 'a'] = new Trie();
                    }
                    current = current.map[chars[i] - 'a'];

                }
                current.isLeaf = true;
            }
        }


        public StreamChecker(String[] words) {
            root = new Trie();
            for(String word : words)
                root.addWord(word);
            letters = new ArrayList<>();
        }

        public boolean query(char letter) {
            letters.add(letter);
            Trie current = root;
            for (int i = letters.size() - 1; i >= 0 && current != null; i--) {
                char c = letters.get(i);
                current = current.map[c - 'a'];
                if (current != null && current.isLeaf) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String[] words = {"ab","ba","aaab","abab","baa"};
        StreamChecker obj = new StreamChecker(words);
        System.out.println(obj.query('a'));//false
        System.out.println(obj.query('a'));//false
        System.out.println(obj.query('a'));//false
        System.out.println(obj.query('a'));//false
        System.out.println(obj.query('a'));//false
        System.out.println(obj.query('b'));//true
        System.out.println(obj.query('a'));//true
        System.out.println(obj.query('b'));//true
        System.out.println(obj.query('a'));//true
        System.out.println(obj.query('b'));//true
        System.out.println(obj.query('b'));//false
        System.out.println(obj.query('b'));//false

        System.out.println(obj.query('a'));//true
        System.out.println(obj.query('b'));//true
        System.out.println(obj.query('a'));//true
        System.out.println(obj.query('b'));//true
        System.out.println(obj.query('b'));//false
        System.out.println(obj.query('b'));//false
        System.out.println(obj.query('b'));//false
        System.out.println(obj.query('a'));//true
        System.out.println(obj.query('b'));//true
        System.out.println(obj.query('a'));//true
        System.out.println(obj.query('b'));//true
        System.out.println(obj.query('a'));//true

        System.out.println(obj.query('a'));//true
        System.out.println(obj.query('a'));//false
        System.out.println(obj.query('b'));//true
        System.out.println(obj.query('a'));//true
        System.out.println(obj.query('a'));//true
        System.out.println(obj.query('a'));//false
    }
}
