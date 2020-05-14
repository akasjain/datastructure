package ds.array;

import java.util.*;

/**
 * https://github.com/akasjain/datastructure/blob/master/TechAJain/src/leetcode/challenge/april/C07_CountingElements.java
 */
public class CountingElements {
    public int countElements(int[] arr) {
        Set<Integer> nums = new HashSet<>();
        for(int num : arr) {
            nums.add(num);
        }
        int result = 0;
        for(int num : arr) {
            if(nums.contains(num + 1)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountingElements ce = new CountingElements();

        int[] arr = new int[]{1,3,2,3,5,0,2};
        System.out.println(ce.countElements(arr));


    }
}
