package ds.array.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        boolean existsMin = false;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == Integer.MIN_VALUE)    existsMin = true;
            if (nums[i] == first || nums[i] == second || nums[i] ==third) continue;

            if(nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if(nums[i] > second) {
                third = second;
                second = nums[i];
            } else if(nums[i] > third) {
                third = nums[i];
            }
        }
        if(existsMin) {
            if(first != Integer.MIN_VALUE) {
                if(second != Integer.MIN_VALUE) {
                    return third;
                } else {
                    return first;
                }

            } else {
                return first;
            }
        }
        if(third == Integer.MIN_VALUE)
            return first;
        else
            return third;

    }
}
