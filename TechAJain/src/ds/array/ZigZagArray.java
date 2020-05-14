package ds.array;

import java.util.Arrays;

public class ZigZagArray {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 7, 8, 6, 2, 1};
        zigzag(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void zigzag(int[] arr) {

        boolean flag = true; // true will indicate that we want < relation

        for (int i = 0; i < arr.length-1; i++) {
            if(flag) {
                if(arr[i] > arr[i+1])
                    swap(arr, i, i+1);
            } else {
                if(arr[i] < arr[i+1])
                    swap(arr, i, i+1);
            }
            flag = !flag;
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
    }
}
