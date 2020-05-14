package ds.array;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {

  public static void main(String[] args) {
    double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
    System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
  }

  private static double[] findAverages(int k, int[] arr) {
    int arrLen = arr.length;
    double[] result = new double[arrLen - k + 1];
    int start = 0, end, windowSum = 0;

    for (end = 0; end < arrLen; end++) {
      windowSum += arr[end];

      if(end >= k-1) {
        result[start] = windowSum / k;
        windowSum -= arr[start];
        start++;
      }
    }

    return result;
  }
}
