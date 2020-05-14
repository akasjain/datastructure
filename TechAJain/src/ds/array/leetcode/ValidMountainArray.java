package ds.array.leetcode;

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int len = A.length;
        if(len < 3) return false;

        boolean isInc = false;
        boolean isDec = false;
        int i = 1;

        while(i < len && A[i] >= A[i-1]) {
            isInc = true;
            i++;
        }
        while(i < len && A[i] < A[i-1]) {
            isDec = true;
            i++;
        }
        if(i == len && isInc && isDec)
            return true;
        return false;


    }

    public static void main(String[] args) {
        /**
         * Example 1:
         *
         * Input: [2,1]
         * Output: false
         * Example 2:
         *
         * Input: [3,5,5]
         * Output: false
         * Example 3:
         *
         * Input: [0,3,2,1]
         * Output: true
         */
    }
}
