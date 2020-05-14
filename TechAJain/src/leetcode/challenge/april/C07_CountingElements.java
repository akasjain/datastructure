package leetcode.challenge.april;

import ds.array.CountingElements;

import java.util.HashSet;
import java.util.Set;

/**
 Given an integer array arr, count element x such that x + 1 is also in arr. If there’re duplicates in arr, count them separately.

 Example 1:
    Input: arr = [1,2,3]
    Output: 2
    Explanation: 1 and 2 are counted cause 2 and 3 are in arr.

 Example 2:
    Input: arr = [1,1,3,3,5,5,7,7]
    Output: 0
    Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.

 Example 3:
    Input: arr = [1,3,2,3,5,0]
    Output: 3
    Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.

 Example 4:
    Input: arr = [1,1,2,2]
    Output: 2
    Explanation: Two 1s are counted cause 2 is in arr.

 Constraints:
    1. 1 <= arr.length <= 1000
    2. 0 <= arr[i] <= 1000
 */
public class C07_CountingElements {
    public int countElements(int[] arr) {
        Set<Integer> nums = new HashSet<>();
        for(int num : arr) {
            nums.add(num);
        }
        int result = 0;
        for(int num : arr) {
            if(nums.contains(num + 1)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        C07_CountingElements ce = new C07_CountingElements();

        int[] arr = new int[]{1,3,2,3,5,0,2};
        System.out.println(ce.countElements(arr));

        arr = new int[]{1,1,3,3,5,5,7,7};
        System.out.println(ce.countElements(arr));


    }
}
