package leetcode.challenge.april;

import java.util.HashMap;

/**
 https://leetcode.com/problems/subarray-sum-equals-k/

 Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

 Example 1:
    Input:nums = [1,1,1], k = 2
    Output: 2

 Constraints:
    1. The length of the array is in range [1, 20,000].
    2. The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

 */
public class C22_SubarraySumEqualsKSolution {

    /**
     * Approach - HashMap
     * Time complexity - O(n)
     * Space - O(n)
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap <> ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        C22_SubarraySumEqualsKSolution obj = new C22_SubarraySumEqualsKSolution();
        System.out.println(obj.subarraySum(new int[]{1,1,1}, 2));
    }
}
