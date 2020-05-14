package leetcode.challenge.april;

/**
 Given two strings text1 and text2, return the length of their longest common subsequence.
 If there is no common subsequence, return 0.

 Example 1:
    Input: text1 = "abcde", text2 = "ace"
    Output: 3
    Explanation: The longest common subsequence is "ace" and its length is 3.

 Example 2:
    Input: text1 = "abc", text2 = "abc"
    Output: 3
    Explanation: The longest common subsequence is "abc" and its length is 3.

 Example 3:
    Input: text1 = "abc", text2 = "def"
    Output: 0
    Explanation: There is no such common subsequence, so the result is 0.
 */
public class C26_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {

        if(text1 == null || text2 == null)
            return 0;

        int len1 = text1.length();
        int len2 = text2.length();
        int max = 0;

        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        C26_LongestCommonSubsequence obj = new C26_LongestCommonSubsequence();
        int result = obj.longestCommonSubsequence("abcde", "ace");
        System.out.println(result);
        result = obj.longestCommonSubsequence("abc", "abc");
        System.out.println(result);
        result = obj.longestCommonSubsequence("abc", "def");
        System.out.println(result);
        result = obj.longestCommonSubsequence("bsbininm", "jmjkbkjkv"); // expected 1
        System.out.println(result);
        result = obj.longestCommonSubsequence(null, "jmjkbkjkv"); // expected 1
        System.out.println(result);

    }
}
