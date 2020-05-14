package ds.array;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
  public static void main(String[] args) {
    System.out.println(MinimumWindowSubstring.findPermutation("aabdec", "abc"));
    System.out.println(MinimumWindowSubstring.findPermutation("abdabca", "abc"));
    System.out.println(MinimumWindowSubstring.findPermutation("adcad", "abc"));
  }

  public static String findPermutation(String str, String pattern) {

    int start = 0, matched = 0, minLength = str.length() + 1, subStrStart = 0;
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char chr : pattern.toCharArray())
      freqMap.put(chr, freqMap.getOrDefault(chr, 0) + 1);

    for (int end = 0; end < str.length(); end++) {
      char ch = str.charAt(end);
      if (freqMap.containsKey(ch)) {
        freqMap.put(ch, freqMap.get(ch) - 1);
        if (freqMap.get(ch) >= 0) // count every matching of a character
          matched++;
      }

      // shrink the window if we can, finish as soon as we remove a matched character
      while (matched == pattern.length()) {
        if (minLength > end - start + 1) {
          minLength = end - start + 1;
          subStrStart = start;
        }

        char leftChar = str.charAt(start);
        if (freqMap.containsKey(leftChar)) {
          // note that we could have redundant matching characters, therefore we'll decrement the
          // matched count only when the last occurrence of a matched character is going out of the window
          if (freqMap.get(leftChar) == 0)
            matched--;
          freqMap.put(leftChar, freqMap.get(leftChar) + 1);
        }
        start++;
      }
    }

    return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
  }

}
