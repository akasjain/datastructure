package trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapSum {
    TrieNode root;
    static class TrieNode {
        int count;
        Map<Character, TrieNode> map;

        TrieNode() {
            map = new HashMap<>();
        }
    }

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode current = root;
        char[] chars = key.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            if(!current.map.containsKey(ch)) {
                current.map.put(ch, new TrieNode());
            }
            current = current.map.get(ch);
            if(i == chars.length - 1) {
                current.count = val;
            }
        }
    }

    public int sum(String prefix) {
        TrieNode current = root;
        char[] chars = prefix.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            if(!current.map.containsKey(ch)) {
                return 0;
            }

            current = current.map.get(ch);
        }
        return findSum(current);
    }

    private int findSum(TrieNode current) {
        if(current == null) {
            return 0;
        }
        int sum = current.count;
        for(Map.Entry<Character, TrieNode> entry : current.map.entrySet()) {
            sum += findSum(entry.getValue());
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSum obj = new MapSum();
        obj.insert("apple", 3);
        System.out.println(obj.sum("ap"));
        obj.insert("app", 2);
        System.out.println(obj.sum("ap"));
        obj.insert("apa", 5);
        System.out.println(obj.sum("ap"));
        System.out.println(obj.sum("app"));

        MapSum obj2 = new MapSum();
        obj2.insert("aa", 3);
        System.out.println(obj2.sum("a"));
        obj2.insert("aa", 2);
        System.out.println(obj2.sum("a"));
        System.out.println(obj2.sum("aa"));
        obj2.insert("aaa", 3);
        System.out.println(obj2.sum("aaa"));
        StringBuilder result = new StringBuilder();
        result.deleteCharAt(result.length() - 1);
    }
}
