package ds.cyclicsort;

import java.util.*;

class FirstKMissingPositive {

    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();

        int len = nums.length;
        int i = 0;

        while(i < len) {
            int j = nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= len && nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        Set<Integer> extraNumbers = new HashSet<>();
        for (i = 0; i < len; i++) {
            if(nums[i] != i+1) {
                extraNumbers.add(nums[i]);
                if (missingNumbers.size() < k)
                    missingNumbers.add(i + 1);
                else
                    return missingNumbers;
            }
        }

        if(missingNumbers.size() < k) { //add more numbers

            int j = 1;
            while(missingNumbers.size() != k) {
                if(!extraNumbers.contains(len + j)) {
                    missingNumbers.add(len + j);
                }
                j++;
            }
        }


        return missingNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 2, 3, 4 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { -2, -3, 4 }, 2);
        System.out.println("Missing numbers: " + missingNumbers);
    }
}
