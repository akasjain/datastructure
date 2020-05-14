package leetcode.challenge.may;

/**
 Week1 May4

 Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.

 Example 1:
    Input: num = 5
    Output: 2
    Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

 Example 2:
    Input: num = 1
    Output: 0
    Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

 Constraints:
 The given integer num is guaranteed to fit within the range of a 32-bit signed integer.
 num >= 1
 You could assume no leading zero bit in the integer’s binary representation.
 This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class C04_NumberComplement {

    /**
     * Logic - To find the complement of a number n, subtract n from the next number containing all ones
     */
    public int findComplement(int num) {

        int temp = num;
        int count = 0;
        while(temp > 0) {
            count++;
            temp = temp >> 1;
        }

        int allOnes = 1;
        while(count > 1) {
            allOnes = (allOnes << 1) + 1;
            count--;
        }

        return allOnes - num;
    }

    public static void main(String[] args) {
        C04_NumberComplement obj = new C04_NumberComplement();
        System.out.println(obj.findComplement(5));
        System.out.println(obj.findComplement(2147483646));
        System.out.println(obj.findComplement(0));
        System.out.println(obj.findComplement(1));
        System.out.println(obj.findComplement(2147483647));
    }
}
