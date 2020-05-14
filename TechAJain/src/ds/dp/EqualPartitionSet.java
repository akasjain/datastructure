package ds.dp;

public class EqualPartitionSet {
  public static void main(String[] args) {
    int[] num = {1, 2, 3, 4};
    System.out.println(canPartition(num));

  }

  private static boolean canPartition(int[] num) {
    int sum = 0;
    int n = num.length;
    for (int i : num)
      sum += i;
    int numOfCols = sum/2 + 1;

    boolean [][]dp = new boolean[n][numOfCols];

    for (int i = 0; i < n ; i++)
      dp[i][0] = true;

    for (int i = 1; i < numOfCols ; i++) {
      if(num[0] == i)
        dp[0][i] = true;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < numOfCols ; j++) {
        if(num[i] <= j) {
          dp[i][j] = dp[i-1][j - num[i]] || dp[i-1][j-1]; // include || exclude
        } else {
          dp[i][j] = dp[i-1][j-1]; // if number is less than sum, we can't include it. only exclude
        }
      }
    }

    return dp[n-1][numOfCols-1];
  }
}
