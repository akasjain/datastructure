package ds.array.leetcode;

import java.util.Arrays;
import java.util.Queue;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;

        while(left < right) {
            if(A[left] %2 != 0 && A[right] %2 != 1) {    //both wrong
                swap(A, left, right);
                left++;
                right--;
            } else if(A[left] %2 == 0) {
                left++;
            } else if(A[right] %2 == 1) {
                right--;
            } else {  // both correct
                left++;
                right--;
            }
        }
        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,4};
        new SortArrayByParity().sortArrayByParity(arr);
        System.out.println(Arrays.toString(arr));
    }
}
