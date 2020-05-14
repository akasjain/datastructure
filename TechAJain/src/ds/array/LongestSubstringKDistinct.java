package ds.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
  }

  private static int findLength(String str, int k) {
    int max = Integer.MIN_VALUE;
    int start = 0, end;

    Map<Character, Integer> map = new HashMap<>();

    for (end = 0; end < str.length(); end++) {

      char ch = str.charAt(end);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
      while(map.size() > k) {
        int val = map.get(ch);
        if(val == 0)
          map.remove(ch);
        else
          map.put(ch, val - 1);
        start++;
      }

      max = Math.max(max, end - start + 1);


    }

    return max;
  }
}
