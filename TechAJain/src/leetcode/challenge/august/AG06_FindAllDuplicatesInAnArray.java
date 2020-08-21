package leetcode.challenge.august;

import java.util.ArrayList;
import java.util.List;

/**
 442. Find All Duplicates in an Array
 https://leetcode.com/problems/find-all-duplicates-in-an-array/

 Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 Find all the elements that appear twice in this array.
 Could you do it without extra space and in O(n) runtime?

 Example:
    Input: [4,3,2,7,8,2,3,1]
    Output: [2,3]
 */
public class AG06_FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>();
        if(len < 2) {
            return result;
        }
        int i = 0;
        while(i < len) {
            if(nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        for(i = 0; i < len; i++) {
            if(nums[i] != i+1)
                result.add(nums[i]);
        }
        return result;

    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
