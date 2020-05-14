package ds.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {
  public static void main(String[] args) {
    System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
    System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
  }

  public static List<Integer> findStringAnagrams(String str, String pattern) {
    int start = 0, end;
    int matched = 0;
    List<Integer> list = new ArrayList<>();
    Map<Character, Integer> charFreqMap = new HashMap<>();

    for (char ch : pattern.toCharArray())
      charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);

    for (end = 0; end < str.length(); end++) {

      char ch = str.charAt(end);
      // If character is in pattern, then reduce its frequency.
      if(charFreqMap.containsKey(ch)) {
        charFreqMap.put(ch, charFreqMap.get(ch) - 1);
        if (charFreqMap.get(ch) == 0)
          matched++;
      }

      // Anagram is found
      if(matched == charFreqMap.size())
        list.add(start);

      // Shrink the window. Increment count of start char in the map.
      if(end >= pattern.length() - 1) {

        char startChar = str.charAt(start);
        if(charFreqMap.containsKey(startChar)) {
          if (charFreqMap.get(startChar) == 0)
            matched--;
          charFreqMap.put(startChar, charFreqMap.get(startChar) + 1);
        }
        start++;
      }
    }

    return list;


  }
}
