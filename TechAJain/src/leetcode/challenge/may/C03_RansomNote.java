package leetcode.challenge.may;

import java.util.HashMap;
import java.util.Map;

/**
 Week1 May3
 Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 Each letter in the magazine string can only be used once in your ransom note.

 Example 1:
    Input: ransomNote = "a", magazine = "b"
    Output: false

 Example 2:
    Input: ransomNote = "aa", magazine = "ab"
    Output: false

 Example 3:
    Input: ransomNote = "aa", magazine = "aab"
    Output: true

 Constraints:
 You may assume that both strings contain only lowercase letters.
 */
public class C03_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote == null)
            return true;
        if(magazine == null)
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) {
                    map.remove(ch);
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
