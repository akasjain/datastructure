package leetcode.challenge.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 https://leetcode.com/problems/find-all-anagrams-in-a-string/

 Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:
    Input:  s: "cbaebabacd" p: "abc"
    Output: [0, 6]
 */
public class C17_FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if(s == null || p == null || p.length() > s.length())
            return result;

        int patLen = p.length();
        int strLen = s.length();
        int start = 0;
        int uniqueCount = 0;

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int end = 0; end < strLen; end++) {
            char currentChar = s.charAt(end);

            if(!map.containsKey(currentChar)) {
                while(start < end) {
                    char startChar = s.charAt(start);
                    map.put(startChar, map.get(startChar) + 1);
                    uniqueCount--;
                    start++;
                }
                start++;
                continue;
            } else {
                map.put(currentChar, map.get(currentChar) - 1);
                uniqueCount += map.get(currentChar) >= 0 ? 1 : 0;
            }


            if(uniqueCount == patLen) {
                result.add(start);
            }

            if(end - start + 1 == patLen) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) + 1);
                if(map.get(startChar) > 0)
                    uniqueCount--;
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        C17_FindAllAnagramsInAString obj = new C17_FindAllAnagramsInAString();
        System.out.println(obj.findAnagrams("cbaebabacd", "abc").toString());
    }
}
