package ds.array;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabcbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
  }

  private static int findLength(String str) {
    int max = 1;
    int start = 0, end;
    Map<Character, Integer> map = new HashMap<>();

    for (end = 0; end < str.length(); end++) {
      char ch = str.charAt(end);

      if(map.containsKey(ch)) {
        start = Math.max(start, map.get(ch) + 1);
      }
      map.put(ch, end);
      max = Math.max(max, end - start + 1);

    }
    return max;
  }


}
