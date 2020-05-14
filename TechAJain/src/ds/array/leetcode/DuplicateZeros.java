package ds.array.leetcode;

import java.util.Arrays;

/**
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 *
 * Do the above modifications to the input array in place, do not return anything from your function.
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {

        int length = arr.length;
        int numOfDups = 0;
        for(int i = 0; i < length - numOfDups; i++) {

            if(arr[i] == 0) {
                if(i == length - numOfDups - 1) {
                    arr[length - 1] = 0;
                    length--;
                    break;
                }
                numOfDups++;
            }
        }
        if(numOfDups == 0)
            return;

        for(int i = length - 1; i >=0; i--) {
            if(arr[i - numOfDups] == 0) {
                arr[i] = 0;
                arr[--i] = 0;
                numOfDups--;
            } else {
                arr[i] = arr[i - numOfDups];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2,3,0,4,5,0};   //Result - 1,0,0,2,3,0,0,4
        new DuplicateZeros().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1,2,3};   // Result - []
        new DuplicateZeros().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

    }
}
