package ds.array;

import java.util.*;

class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {

        int len = arr.length;
        int left, right;
        int smallestDiffTriplet = Integer.MAX_VALUE;

        for (int i = 0; i < len-1; i++) {
            // current element under consideration is a[i]. targetSum - a[i]
            left = i + 1;
            right = len - 1;
            while(left < right) {
                int diff = targetSum - arr[i] - arr[left] - arr[right];
                if (diff == 0) {
                    return 0;
                }

                if (Math.abs(diff) < Math.abs(smallestDiffTriplet) ||
                        ((Math.abs(diff) == smallestDiffTriplet) && (diff > smallestDiffTriplet))) {
                    smallestDiffTriplet = diff;
                }
                if(diff > 0)
                    left++;
                else
                    right--;
            }
        }


        return targetSum - smallestDiffTriplet;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }
}
