package ds.array;

import java.util.*;

class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        int count = 0;

        int len = arr.length;
        int left, right;
        Arrays.sort(arr);
        for (int i = 0; i < len - 1; i++) {
            left = i + 1;
            right = len - 1;

            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}