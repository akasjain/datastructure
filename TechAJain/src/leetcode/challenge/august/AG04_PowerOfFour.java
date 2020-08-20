package leetcode.challenge.august;

/**
 https://leetcode.com/problems/power-of-four/

 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example 1:
    Input: 16
    Output: true

 Example 2:
    Input: 5
    Output: false

 Follow up: Could you solve it without loops/recursion?
 */
public class AG04_PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if(num <= 0)
            return false;

        int numOfZeros = 0;
        int numOfOnes = 0;
        while(num > 0) {
            if((num & 1) == 1) {
                numOfOnes++;
            } else {
                numOfZeros++;
            }
            num = num >> 1;
        }
        if (numOfOnes != 1)
            return false;

        if(numOfZeros % 2 == 0)
            return true;

        return false;
    }
}
