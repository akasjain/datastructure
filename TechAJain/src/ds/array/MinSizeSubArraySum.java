package ds.array;

public class MinSizeSubArraySum {
  public static void main(String[] args) {
    int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
    System.out.println("Smallest subarray length: " + result);
  }

  private static int findMinSubArray(int sum, int[] arr) {

    int min = Integer.MAX_VALUE;
    int start = 0, end, subArraySum = 0;

    for (end = 0; end < arr.length; end++) {
      subArraySum += arr[end];

      while(subArraySum >= sum) {
        min = Math.min(min, end - start + 1);
        subArraySum -= arr[start];
        start++;
      }
    }
    return min;
  }
}
