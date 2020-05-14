package leetcode.challenge.april;

/**
 https://leetcode.com/problems/single-number/

 Given a non-empty array of integers, every element appears twice except for one. Find that single one.

 Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Example 1:
    Input: [2,2,1]
    Output: 1

 Example 2:
    Input: [4,1,2,1,2]
    Output: 4
 */
public class C01_SingleNumber {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int single = nums[0];
        for(int i=1; i<len; i++) {
            single = single ^ nums[i];
        }

        return single;
    }
}
