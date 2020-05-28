package leetcode.challenge.may;

import java.util.HashMap;
import java.util.Map;

/**
 https://leetcode.com/problems/contiguous-array/

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
public class C26_ContiguousArray {
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
        C26_ContiguousArray obj = new C26_ContiguousArray();
        System.out.println(obj.findMaxLength(new int[]{0, 1}));
        System.out.println(obj.findMaxLength(new int[]{0, 1, 0}));
        System.out.println(obj.findMaxLength(new int[]{1, 1, 0, 0, 1}));

    }
}
