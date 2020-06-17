package leetcode.challenge.june;

/**
 https://leetcode.com/problems/coin-change-2/

 Coin Change 2

 You are given coins of different denominations and a total amount of money.
 Write a function to compute the number of combinations that make up that amount.
 You may assume that you have infinite number of each kind of coin.

 Example 1:
    Input: amount = 5, coins = [1, 2, 5]
    Output: 4
    Explanation: there are four ways to make up the amount: 5=5     5=2+2+1     5=2+1+1+1       5=1+1+1+1+1

 Example 2:
    Input: amount = 3, coins = [2]
    Output: 0
    Explanation: the amount of 3 cannot be made up just with coins of 2.

 Example 3:
    Input: amount = 10, coins = [10]
    Output: 1

 Note:
 You can assume that
    0 <= amount <= 5000
    1 <= coin <= 5000
    the number of coins is less than 500
    the answer is guaranteed to fit into signed 32-bit integer
 */
public class J07_CoinChange2 {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        if(len == 0)
            return amount == 0 ? 1 : 0;
        int[][] dp = new int[len][amount+1];
        for(int i = 0; i < len; i++) {
            dp[i][0] = 1;
        }

        for(int i = 0; i < len; i++) {
            for(int j = 1; j <= amount; j++) {
                if(coins[i] <= j)
                    dp[i][j] = dp[i][j - coins[i]];

                if(i > 0)
                    dp[i][j] += dp[i-1][j];
            }
        }

        return dp[len - 1][amount];
    }

    public static void main(String[] args) {
        J07_CoinChange2 obj = new J07_CoinChange2();
        System.out.println(obj.change(10, new int[]{2,3,5}));
    }
}
