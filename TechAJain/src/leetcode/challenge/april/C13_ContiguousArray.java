package leetcode.challenge.april;

import java.util.HashMap;
import java.util.Map;

/**
 Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

 Example 1:
    Input: [0,1]
    Output: 2
    Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

 Example 2:
    Input: [0,1,0]
    Output: 2
    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

 Note: The length of the given binary array will not exceed 50,000.
 */
public class C13_ContiguousArray {

    /**
     * Logic -
     * Map Key stores Sum of 0's and 1's uptil index i.
     * Map Value stores the first occurrence(i.e. index) of the sum denoted by key.
     * Initialize map by (0, -1) to indicate that empty array has sum 0 and index -1
     *
     * When count value is also present in the map, it means that equal number of 0's and 1's appear between current index i and map.get(count)
     */
    public int findMaxLength(int[] nums) {
        int max = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                count--;
            else
                count++;

            if(map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        C13_ContiguousArray obj = new C13_ContiguousArray();
        int[] nums = new int[]{0,1,0,0,1,1,1,0};
        System.out.println(obj.findMaxLength(nums));
    }
}
