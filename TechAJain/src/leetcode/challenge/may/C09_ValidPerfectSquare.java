package leetcode.challenge.may;

/**
 Week2 May9
 https://leetcode.com/problems/valid-perfect-square/

 Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:
    Input: 16
    Output: true

 Example 2:
    Input: 14
    Output: false
 */
public class C09_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num==0 || num==1){
            return true;
        }
        int start = 1, end = num;

        while(start <= end){
            int mid = start + (end - start) / 2;
            Long t =(long) mid * mid;
            if(t > Integer.MAX_VALUE)
                end = mid - 1;
            else if(mid * mid == num)
                return true;
            else if(mid * mid < num)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}
