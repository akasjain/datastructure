package ds.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarrayProductLessThanK {
  public static void main(String[] args) {
    System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
    System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
  }

  public static List<List<Integer>> findSubarrays(int[] arr, int target) {
    List<List<Integer>> result = new ArrayList<>();
    int len = arr.length;
    int product = 1;
    int left=0, right;

    for (right = 0; right < len; right++) {
      product *= arr[right];

      while(product >= target && left <= right) {
        product /= arr[left++];
      }


      List<Integer> tempList = new ArrayList<>();
      for (int i = right; i >= left; i--) {
        tempList.add(arr[right]);
        result.add(new ArrayList<>(tempList));
      }

    }





    return result;
  }
}
