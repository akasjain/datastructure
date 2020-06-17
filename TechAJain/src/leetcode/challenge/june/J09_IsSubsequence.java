package leetcode.challenge.june;

/**
 https://leetcode.com/problems/is-subsequence/

 Is Subsequence

 Given a string s and a string t, check if s is subsequence of t.
 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
 the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

 Follow up:
 If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

 Example 1:
    Input: s = "abc", t = "ahbgdc"
    Output: true

 Example 2:
    Input: s = "axc", t = "ahbgdc"
    Output: false
 */
public class J09_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        boolean[][] dp = new boolean[sLen + 1][tLen + 1];
        for(int i = 0; i <= tLen; i++) {
            dp[0][i] = true;
        }

        for(int i = 1; i <= sLen; i++) {
            for(int j = 1; j <= tLen; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[sLen][tLen];
    }

    public static void main(String[] args) {
        J09_IsSubsequence obj = new J09_IsSubsequence();
        System.out.println(obj.isSubsequence("abc","ahbgdc"));
        System.out.println(obj.isSubsequence("axc","ahbgdc"));
    }
}
