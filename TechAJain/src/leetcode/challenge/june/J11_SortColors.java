package leetcode.challenge.june;

import java.util.Arrays;

/**
 https://leetcode.com/problems/sort-colors/

 Sort Colors
 Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
 with the colors in the order red, white and blue.
 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note: You are not suppose to use the library's sort function for this problem.

 Example:
    Input: [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]
 */
public class J11_SortColors {
    public void sortColors(int[] nums) {
        int len = nums.length; //6
        int start = 0; //0
        int end = len - 1; //5
        int i = 0;
        while(i < len && i <= end) {
            switch(nums[i]) {
                case 0 : swap(nums, i, start); start++; i++; break;
                case 1 : i++; break;
                case 2 : swap(nums, i, end); end--; break;
            }
        }
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        J11_SortColors obj = new J11_SortColors();
        int[] nums = new int[]{2,0,2,1,1,0};
        obj.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
