package ds.array;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
  public static void main(String[] args) {
    System.out.println(CharacterReplacement.findLength("aabcdbb", 2));
    //System.out.println(CharacterReplacement.findLength("abbcb", 1));
    //System.out.println(CharacterReplacement.findLength("abccde", 1));
  }

  private static int findLength(String str, int k) {
    int start = 0, end, maxLength = Integer.MIN_VALUE, maxCount = Integer.MIN_VALUE;
    Map<Character, Integer> map = new HashMap<>();

    for (end = 0; end < str.length(); end++) {
      char ch = str.charAt(end);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
      maxCount = Math.max(maxCount, map.get(ch));

      if(end - start + 1 - maxCount > k) {
        char startChar = str.charAt(start);
        map.put(startChar, map.get(startChar) - 1);
        start++;
      }

      maxLength = Math.max(maxLength, end - start  +1);
    }

    return maxLength;
  }


}
