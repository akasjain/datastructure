package ds.dp;

public class Knapsack01 {

  public static void main(String[] args) {
    int capacity = 7;
    int[] profits = {1, 6, 10, 16};
    int[] weights = {1, 2, 3, 5};
    int[][] knapsack = solveKnapsack(profits, weights, 7);
    System.out.println("Max Profit " + knapsack[profits.length - 1][capacity]);

    printSelectedElements(knapsack, weights, profits, capacity);

  }

  private static int[][] solveKnapsack(int[] profits, int[] weights, int capacity) {

    int n = profits.length;
    int[][] knap = new int[n][capacity + 1];

    for (int i = 1; i <= capacity ; i++) {
      if(weights[0] <= i)
        knap[0][i] = profits[0];
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= capacity; j++) {
        if(weights[i] <= j) {
          knap[i][j] = Math.max(knap[i-1][j], profits[i] + knap[i-1][j - weights[i]]);
        } else {
          knap[i][j] = knap[i-1][j];
        }
      }
    }

    return knap;
  }

  private static void printSelectedElements(int dp[][], int[] weights, int[] profits, int capacity){

    int n = weights.length;

    System.out.print("Selected weights:");
    int totalProfit = dp[n-1][capacity];

    for(int i = n-1; i > 0; i--) {
      if(totalProfit != dp[i-1][capacity]) {
        System.out.print(" " + weights[i]);
        capacity -= weights[i];
        totalProfit -= profits[i];
      }
    }

    if(totalProfit != 0)
      System.out.print(" " + weights[0]);
    System.out.println("");
  }


}
