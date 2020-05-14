package ds.array.leetcode;

import java.util.Arrays;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveAllInstances {
    public int removeElement(int[] nums, int val) {

        int fill = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[fill++] = nums[i];
            }
        }
        return fill;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,2,3};
        int newSize = new RemoveAllInstances().removeElement(arr, 3);
        System.out.println(Arrays.toString(Arrays.copyOf(arr, newSize)));
        arr = new int[]{0,1,2,2,3,0,4,2};
        newSize = new RemoveAllInstances().removeElement(arr, 2);
        System.out.println(Arrays.toString(Arrays.copyOf(arr, newSize)));

    }
}
