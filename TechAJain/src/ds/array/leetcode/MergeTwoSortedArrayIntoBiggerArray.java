package ds.array.leetcode;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 */
public class MergeTwoSortedArrayIntoBiggerArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int idx = m+n-1;

        while(i >= 0 && j >= 0) {
            int ele = 0;
            if(nums1[i] > nums2[j]) {
                ele = nums1[i];
                i--;
            } else {
                ele = nums2[j];
                j--;
            }
            nums1[idx--] = ele;
        }
        while(j >= 0) {
            nums1[idx--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        new MergeTwoSortedArrayIntoBiggerArray().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

    }
}
