package ds.cyclicsort;

import java.util.*;

class AllMissingNumbers {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        int i = 0;
        int len = nums.length;

        while(i < len) {
            int j = nums[i] - 1;
            if(nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        i = 0;
        while(i < len) {
            if(nums[i] != i+1)
                missingNumbers.add(i+1);
            i++;
        }

        return missingNumbers;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);
    }
}