package leetcode.challenge.april;

import java.util.Arrays;

/**
 https://leetcode.com/problems/move-zeroes/

 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Example:
    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]

 Note:
    1. You must do this in-place without making a copy of the array.
    2. Minimize the total number of operations.
 */
public class C04_MoveZeroes {
    public void moveZeroes(int[] nums) {

        int nextZeroIdx = 0;
        int numOfZeros = 0;
        int len = nums.length;

        for(int i = 0; i < len; i++) {
            if(nums[i] != 0) {
                nums[nextZeroIdx] = nums[i];
                nextZeroIdx++;
            } else {
                numOfZeros++;
            }
        }

        int j = 0;
        while(j < numOfZeros) {
            nums[len - 1 - j] = 0;
            j++;
        }
    }

    public static void main(String[] args) {
        C04_MoveZeroes obj = new C04_MoveZeroes();
        int[] num = {0,1,0,3,12};
        obj.moveZeroes(num);
        System.out.println(Arrays.toString(num));
    }
}
