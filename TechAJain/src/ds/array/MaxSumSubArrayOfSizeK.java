package ds.array;

public class MaxSumSubArrayOfSizeK {

  public static void main(String[] args) {
    System.out.println("Maximum sum of a subarray of size K: "
      + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
    System.out.println("Maximum sum of a subarray of size K: "
      + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
  }

  private static int findMaxSumSubArray(int k, int[] arr) {
    int max = Integer.MIN_VALUE;
    int startFinal = 0;
    int endFinal = k-1;
    int start = 0, end, windowSum = 0;

    for (end = 0; end < arr.length; end++) {
      windowSum += arr[end];
      if(end >= k-1) {
        if(max < windowSum) {
          max = windowSum;
          startFinal = start;
          endFinal = end;

        }
        windowSum -= arr[start];
        start++;
      }
    }
    System.out.println(startFinal + "," + endFinal);
    return max;


  }
}
