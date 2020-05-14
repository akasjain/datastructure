package ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class TripletSum {
  public static void main(String[] args) {
    int[] arr = {2,7,4,0,9,5,1,3};
    int n = arr.length;
    Scanner sc = new Scanner(System.in);
    int sum = sc.nextInt();

    boolean isTriplet = tripleExistsMethod1(arr, n, sum, 0);
    if(isTriplet)
      System.out.println("Triplet found");
    else {
      System.out.println("Triplet not found");
    }

    System.out.println("---Method 2---");
    isTriplet = tripleExistsMethod2(arr, n, sum);
    if(isTriplet)
      System.out.println("Triplet found");
    else {
      System.out.println("Triplet not found");
    }

    System.out.println("---Method 3---");
    tripleExistsMethod3(arr, n, sum);


  }

  private static boolean tripleExistsMethod1(int[] a, int n, int sum, int count) {

    if (count == 3 && sum == 0) {
      return true;
    }
    if (n == 0 || count == 3 || sum < 0) {
      return false;
    }
    return tripleExistsMethod1(a, n - 1, sum - a[n - 1], count + 1) ||
      tripleExistsMethod1(a, n - 1, sum, count);
  }

  private static boolean tripleExistsMethod2(int[] a, int n, int sum) {

    Map<Integer, Integer> map = new HashMap<>();
    Arrays.stream(a).forEach(num -> map.put(num, map.size()));
    Stream.of(map).forEach(v -> System.out.println(v));

    for (int i = 0; i < n-1; i++) {

      for (int j = i+1; j < n; j++) {
        int remainingSum = sum - (a[i] + a[j]);

        if(map.containsKey(remainingSum)) {
          if (map.get(remainingSum)!= i && map.get(remainingSum)!= j) {
            return true;
          }
        }
      }

    }
    return false;
  }

  private static void tripleExistsMethod3(int[] a, int n, int sum) {

    Arrays.sort(a);
    for (int i = 0; i <= n-3; i++) {
      int remainingSum = sum - a[i];
      int low = i+1;
      int high = n-1;

      while(low<high) {
        if(a[low] + a[high] < remainingSum)
          low++;
        else if(a[low] + a[high] > remainingSum)
          high--;
        else {
          System.out.println(String.format("Triplet -> (%s,%s,%s) ", a[i], a[low], a[high]));
          low++;
          high--;
        }
      }
    }
  }
}
