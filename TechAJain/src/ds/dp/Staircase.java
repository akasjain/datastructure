package ds.dp;

import java.util.Arrays;

public class Staircase {
  static int countWays(int n, int[] stepSize) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, 0);
    dp[0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < stepSize.length; j++) {
        if(stepSize[j] <= i) {
          dp[i] += dp[i - stepSize[j]];
        }
      }
    }
    System.out.println(Arrays.toString(dp));

    return dp[n];
  }

  /**
   * A person ca take 1,2 or 3 steps. Find number of ways he can reach given staircase @numOfStaircase
   * @param numOfStaircase
   * @return
   */
  static int countWaysSequentialSteps(int numOfStaircase) {

    int[] dp = new int[numOfStaircase + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;

    for (int i = 4; i <= numOfStaircase; i++) {
      dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    }

    return dp[numOfStaircase];
  }

  public static void main(String[] args) {
    int x = countWays(5, new int[]{1,3,4});
    System.out.println("ways " + x);

    System.out.println(countWaysSequentialSteps(7));
  }
}
