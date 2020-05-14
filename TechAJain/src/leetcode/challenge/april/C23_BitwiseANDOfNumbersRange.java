package leetcode.challenge.april;

/**
 https://leetcode.com/problems/bitwise-and-of-numbers-range/

 Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

 Example 1:
    Input: [5,7]
    Output: 4

 Example 2:
    Input: [0,1]
    Output: 0
 */
public class C23_BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        while(n > m)
            n = n & n-1;
        return m & n;
    }

    public static void main(String[] args) {
        C23_BitwiseANDOfNumbersRange obj = new C23_BitwiseANDOfNumbersRange();
        System.out.println(obj.rangeBitwiseAnd(5,  7));
        System.out.println(obj.rangeBitwiseAnd(0,  2147483647));
        System.out.println(obj.rangeBitwiseAnd(2147483640,  2147483647));
    }
}
