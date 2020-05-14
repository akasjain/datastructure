package leetcode.challenge.may;

/**
 Week2 May12
 https://leetcode.com/problems/single-element-in-a-sorted-array/

 You are given a sorted array consisting of only integers where every element appears exactly twice,
 except for one element which appears exactly once. Find this single element that appears only once.

 Example 1:
    Input: [1,1,2,3,3,4,4,8,8]
    Output: 2

 Example 2:
    Input: [3,3,7,7,10,11,11]
    Output: 10
 */

public class C12_SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if(mid % 2 == 0) {
                if(nums[mid] == nums[mid + 1]) {
                    start = mid + 2;
                } else {
                    end = mid;
                }
            } else {  //mid is odd
                if(nums[mid - 1] == nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return len > 0 ? nums[start] : -1;
    }

    public static void main(String[] args) {
        C12_SingleElementInASortedArray obj = new C12_SingleElementInASortedArray();
        System.out.println(obj.singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}));
        System.out.println(obj.singleNonDuplicate(new int[] {3,3,7,7,10,11,11}));
        System.out.println(obj.singleNonDuplicate(new int[] {1,1,2}));
        System.out.println(obj.singleNonDuplicate(new int[] {1,2,2}));
    }
}

