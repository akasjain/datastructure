package leetcode.challenge.may;

import java.util.Arrays;

/**
 https://leetcode.com/problems/permutation-in-string/

 Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 In other words, one of the first string's permutations is the substring of the second string.

 Example 1:
    Input: s1 = "ab" s2 = "eidbaooo"
    Output: True
    Explanation: s2 contains one permutation of s1 ("ba").

 Example 2:
    Input:s1= "ab" s2 = "eidboaoo"
    Output: False

 Note:
    1. The input strings only contain lower case letters.
    2. The length of both given strings is in range [1, 10,000].
 */
public class C18_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.equals("") || s1 == null || s2.equals("") || s2 == null)
            return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();
        int start = 0;

        for(char ch : s1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        for(int end = 0; end < len2; end++) {
            freq2[s2.charAt(end) - 'a']++;
            if(end >= len1) {
                freq2[s2.charAt(start) - 'a']--;
                start++;
            }

            if(Arrays.equals(freq1, freq2))
                return true;
        }
        return false;
    }
}
