package leetcode.challenge.may;

import java.util.Arrays;

/**
 https://leetcode.com/problems/counting-bits/

 Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

 Example 1:
    Input: 2
    Output: [0,1,1]

 Example 2:
    Input: 5
    Output: [0,1,1,2,1,2]
 */
public class C28_CountingBits {
    public int[] countBits(int num) {
        if(num == 0)
            return new int[]{0};

        int[] dp = new int[num+1];
        dp[0] = 0; // not required, explicitly assigned for readability
        dp[1] = 1;

        int index = 2;
        for(int i = 2; i <= num; i = 2 * i) {
            int min = i / 2;
            int max = i - 1;
            for(int k = min; k <= max; k++) {
                if(index <= num) {
                    dp[index++] = dp[k];
                }
                if(index <= num) {
                    dp[index++] = dp[k] + 1;
                }
                if(index > num)
                    break;
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        C28_CountingBits obj = new C28_CountingBits();
        int[] result = obj.countBits(2);
        System.out.println(Arrays.toString(result));
    }
}
