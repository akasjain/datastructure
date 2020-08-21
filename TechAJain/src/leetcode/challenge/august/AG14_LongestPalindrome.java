package leetcode.challenge.august;

/**
 409. Longest Palindrome
 https://leetcode.com/problems/longest-palindrome/

 Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 Example 1:
    Input: s = "abccccdd"
    Output: 7
    Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

 Example 2:
    Input: s = "a"
    Output: 1

 Example 3:
    Input: s = "bb"
    Output: 2

 Constraints:
    1 <= s.length <= 2000
    s consits of lower-case and/or upper-case English letters only.
 */
public class AG14_LongestPalindrome {
    public int longestPalindrome(String s) {
        if(s.equals("") || s == null)
            return 0;

        int[] freq = new int[58];
        for(char ch : s.toCharArray()) {
            freq[ch - 'A']++;
        }

        int result = 0;
        int numOfOdds = 0;

        for(int count : freq) {
            if(count %2 == 0) {
                result += count;
            } else {
                numOfOdds++;
                result += count - 1;
            }
        }
        if(numOfOdds > 0)
            result++;

        return result;
    }
}
