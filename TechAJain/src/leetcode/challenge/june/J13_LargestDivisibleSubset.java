package leetcode.challenge.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 https://leetcode.com/problems/largest-divisible-subset/

 Largest Divisible Subset
 Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

 Si % Sj = 0 or Sj % Si = 0.
 If there are multiple solutions, return any subset is fine.

 Example 1:
    Input: [1,2,3]
    Output: [1,2] (of course, [1,3] will also be ok)

 Example 2:
    Input: [1,2,4,8]
    Output: [1,2,4,8]
 */
public class J13_LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return new ArrayList<>();

        Arrays.sort(nums);

        int[] count = new int[len];
        Arrays.fill(count, 1);
        for(int i = 1; i < len; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0) {
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
        }

        int maxIndex = 0;
        for(int i = 1; i < len; i++) {
            maxIndex = count[i] > count[maxIndex] ? i : maxIndex;
        }

        List<Integer> result = new ArrayList<>();
        int currentNum = nums[maxIndex];
        int currentCount = count[maxIndex];

        for(int i = maxIndex; i >= 0; i--) {
            if(currentNum % nums[i] == 0 && currentCount == count[i]) {
                result.add(nums[i]);
                currentNum = nums[i];
                currentCount--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        J13_LargestDivisibleSubset obj = new J13_LargestDivisibleSubset();
        System.out.println(obj.largestDivisibleSubset(new int[]{1,2,3}).toString());
        System.out.println(obj.largestDivisibleSubset(new int[]{2,3,5}).toString());
        System.out.println(obj.largestDivisibleSubset(new int[]{1,2,3,9}).toString());
        System.out.println(obj.largestDivisibleSubset(new int[]{2,3,4,8,9,15,}).toString());
        System.out.println(obj.largestDivisibleSubset(new int[]{1,2,4,8}).toString());
    }
}
