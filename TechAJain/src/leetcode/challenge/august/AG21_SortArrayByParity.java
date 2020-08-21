package leetcode.challenge.august;

import java.util.Arrays;

/**
 905. Sort Array By Parity
 https://leetcode.com/problems/sort-array-by-parity/

 Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 You may return any answer array that satisfies this condition.

 Example 1:
    Input: [3,1,2,4]
    Output: [2,4,3,1]
    The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class AG21_SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        if(len <= 1)
            return A;

        int left = 0;
        int i = 0;

        while(i < len) {
            if(A[i] %2 == 0) {
                swap(A, i, left);
                left++;
            }
            i++;
        }

        return A;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        AG21_SortArrayByParity obj = new AG21_SortArrayByParity();
        int[] resut = obj.sortArrayByParity(new int[]{1,3,5,2,4,7,8});
        System.out.println(Arrays.toString(resut));
    }
}
