package leetcode.challenge.may;

import java.util.HashMap;
import java.util.Map;

/**
 Week1 May6

 Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 You may assume that the array is non-empty and the majority element always exist in the array.

 Example 1:
    Input: [3,2,3]
    Output: 3

 Example 2:
    Input: [2,2,1,1,1,2,2]
    Output: 2
 */
public class C06_MajorityElement {
    public int majorityElement(int[] nums) {
        int majElement = -1;
        int maxFreq = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > maxFreq) {
                maxFreq = map.get(num);
                majElement = num;
            }
        }

        return majElement;
    }

    public static void main(String[] args) {
        C06_MajorityElement obj = new C06_MajorityElement();
        System.out.println(obj.majorityElement(new int[]{3,2,3}));
        System.out.println(obj.majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(obj.majorityElement(new int[]{1,1}));
    }
}
