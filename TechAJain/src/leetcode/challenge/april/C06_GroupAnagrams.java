package leetcode.challenge.april;

import java.util.*;

/**
 https://leetcode.com/problems/group-anagrams/

 Given an array of strings, group anagrams together.

 Example:
    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
     [
     ["ate","eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]

 Note:
    1. All inputs will be in lowercase.
    2. The order of your output does not matter.
 */

public class C06_GroupAnagrams {
    class Word {
        int index;
        String word;

        public Word(int index, String word) {
            this.index = index;
            this.word = word;
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char word[] = strs[i].toCharArray();
            Arrays.sort(word);
            String sortedWord = String.valueOf(word);
            if(map.containsKey(sortedWord)){
                ArrayList<String> list = map.get(sortedWord);
                list.add(strs[i]);
                map.remove(sortedWord);
                map.put(sortedWord,list);
            }
            else{
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sortedWord,list);
            }
        }
        List<List<String>> result = new LinkedList<>();
        for(String s: map.keySet()){
            List<String> group = map.get(s);
            result.add(group);
        }
        return result;
    }

    public static void main(String[] args) {
        C06_GroupAnagrams obj = new C06_GroupAnagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = obj.groupAnagrams(strs);
        for (List<String> group : result) {
            System.out.println(group.toString());
        }
    }
}
