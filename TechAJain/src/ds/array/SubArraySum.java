package ds.array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    public static void main(String[] args) {
        int a[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 24;
        //subArraySumPositiveIntegers(a, sum);

        int[] b = {10, 2, -2, 0, 10};
        sum = -10;
        subArraySumWithNegativeIntegers(b, sum);

        int[] c = {2, 1, 5, 2, 3, 2};
        sum = 7;
        //System.out.println(subArraySumGENumber(a, 24));
    }

    public static boolean subArraySumPositiveIntegers(int arr[], int sum) {

        int n = arr.length;
        int currentSum = arr[0], start = 0, i;

        for (i = 1; i <= n ; i++) {

            while(currentSum > sum && start < i-1) {
                currentSum -= arr[start];
                start++;
            }

            if(currentSum == sum) {
                System.out.println("Found at index " + start + " & " + (i-1));
                return true;
            }

            currentSum += arr[i];

        }

        System.out.println("Not Found");
        return false;
    }

    public static boolean subArraySumWithNegativeIntegers(int arr[], int sum) {

        int n = arr.length;
        int currSum = 0, start, end = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            currSum = currSum + arr[i];

            if(currSum - sum == 0) {
                start = 0;
                end = i;
                System.out.println("Found " + start + " & " + end);
                return true;
            }

            if(map.containsKey(currSum - sum)) {
                start = map.get(currSum - sum) + 1;
                end = i;
                System.out.println("Found " + start + " & " + end);
                return true;
            }
            map.put(currSum, i);
        }

        System.out.println("Not Found");
        return false;
    }

    private static int subArraySumGENumber(int[] a, int s) {
        int n = a.length;
        int start = 0, end, sum = 0, ans = Integer.MAX_VALUE;

        for (end = 0; end < n; end++) {
            sum += a[end];
            while(sum >= s && start <= end) {
                int windowLen = end - start + 1;
                if(windowLen < ans) {
                    System.out.println("Updating at " + start + " and " + (end-1));
                    ans = windowLen;
                }
                //ans = windowLen < ans ? windowLen : ans;
                sum -= a[start];
                start++;
            }


        }
        return ans;

    }
}
