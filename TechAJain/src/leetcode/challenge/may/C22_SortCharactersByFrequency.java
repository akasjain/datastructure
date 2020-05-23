package leetcode.challenge.may;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 https://leetcode.com/problems/sort-characters-by-frequency/

 Given a string, sort it in decreasing order based on the frequency of characters.

 Example 1:
    Input: "tree"
    Output: "eert" or "eetr"
 */
public class C22_SortCharactersByFrequency {
    public String frequencySort(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        maxHeap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> top = maxHeap.poll();
            int count = top.getValue();
            while(count > 0) {
                sb.append(top.getKey());
                count--;
            }
        }
        return sb.toString();
    }
}
