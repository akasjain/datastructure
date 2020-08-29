package leetcode.challenge.august;

import java.util.ArrayList;
import java.util.List;

/**
 969. Pancake Sorting
 https://leetcode.com/problems/pancake-sorting/

 Given an array of integers A, We need to sort the array performing a series of pancake flips.
 In one pancake flip we do the following steps:
 Choose an integer k where 0 <= k < A.length.
 Reverse the sub-array A[0...k].
 For example, if A = [3,2,1,4] and we performed a pancake flip choosing k = 2, we reverse the sub-array [3,2,1], so A = [1,2,3,4] after the pancake flip at k = 2.
 Return an array of the k-values of the pancake flips that should be performed in order to sort A. Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.

 Example 1:
    Input: A = [3,2,4,1]
    Output: [4,2,4,3]
    Explanation:
     We perform 4 pancake flips, with k values 4, 2, 4, and 3.
     Starting state: A = [3, 2, 4, 1]
     After 1st flip (k = 4): A = [1, 4, 2, 3]
     After 2nd flip (k = 2): A = [4, 1, 2, 3]
     After 3rd flip (k = 4): A = [3, 2, 1, 4]
     After 4th flip (k = 3): A = [1, 2, 3, 4], which is sorted.
     Notice that we return an array of the chosen k values of the pancake flips.

 Example 2:
    Input: A = [1,2,3]
    Output: []
    Explanation: The input is already sorted, so there is no need to flip anything.
        Note that other answers, such as [3, 3], would also be accepted.

 Constraints:
    1 <= A.length <= 100
    1 <= A[i] <= A.length
    All integers in A are unique (i.e. A is a permutation of the integers from 1 to A.length).

 https://leetcode.com/problems/pancake-sorting/discuss/818046/Java-100-fast-or-Modular-code-and-easy-to-understand-solution-with-explanation
 */
public class AG29_PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        int len = A.length;

        for(int i = 0; i < len - 1; i++) {
            int finalPos = len - 1 - i;
            int maxIndex = findMax(A, finalPos);

            if(maxIndex == finalPos) {
                continue;
            }
            if(maxIndex != 0) {
                flip(A, maxIndex);
                result.add(maxIndex + 1);
            }
            flip(A, finalPos);
            result.add(finalPos + 1);
        }

        return result;
    }

    private int findMax(int[] A, int upper) {
        int maxVal = 0;
        int maxIdx = 0;
        for(int i = 0; i <= upper; i++) {
            if(A[i] > maxVal) {
                maxVal = A[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private void flip(int[] A, int k) {
        int left = 0;
        int right = k;
        while(left < right) {
            swap(A, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        AG29_PancakeSorting obj = new AG29_PancakeSorting();
        System.out.println(obj.pancakeSort(new int[]{3,2,1,4}).toString());
        System.out.println(obj.pancakeSort(new int[]{3,1,2,4}).toString());
        System.out.println(obj.pancakeSort(new int[]{3,2,4,1}).toString());
    }
}
