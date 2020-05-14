package leetcode.challenge.april;

import java.util.Arrays;

/**
 https://leetcode.com/problems/product-of-array-except-self/

 Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Example:

 Input:  [1,2,3,4]
 Output: [24,12,8,6]
 Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

 Note: Please solve it without division and in O(n).
 */
public class C15_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        int[] left = new int[length];

        // left[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the left[0] would be 1
        left[0] = 1;
        for (int i = 1; i < length; i++) {

            // left[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            left[i] = nums[i - 1] * left[i - 1];
        }

        // right contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the right would be 1
        int right = 1;
        for (int i = length - 1; i >= 0; i--) {

            // For the index 'i', right would contain the
            // product of all elements to the right. We update right accordingly
            left[i] = left[i] * right;
            right *= nums[i];
        }

        return left;
    }

    public static void main(String[] args) {
        C15_ProductOfArrayExceptSelf obj = new C15_ProductOfArrayExceptSelf();
        int[] ans = obj.productExceptSelf(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(ans));

        ans = obj.productExceptSelf(new int[]{1,0,3,4});
        System.out.println(Arrays.toString(ans));

        ans = obj.productExceptSelf(new int[]{1,0,0,4});
        System.out.println(Arrays.toString(ans));

        ans = obj.productExceptSelf(new int[]{0,0});
        System.out.println(Arrays.toString(ans));

    }
}
