package leetcode.challenge.may;

/**
 Week2 May13
 https://leetcode.com/problems/remove-k-digits/

 Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

 Note:
    1. The length of num is less than 10002 and will be ≥ k.
    2. The given num does not contain any leading zero.

 Example 1:
    Input: num = "1432219", k = 3
    Output: "1219"
    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

 Example 2:
    Input: num = "10200", k = 1
    Output: "200"
    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

 Example 3:
    Input: num = "10", k = 2
    Output: "0"
    Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class C13_RemoveKDigits {

    /**
     * Since the length of input num is very large we cannot do a relational comparison of numbers.
     *
     * Logic - Keep pushing each number from input to the string. Before pushing, if the last element is greater than the current
     * new element, keep removing the last element from the string until an equal or smaller number comes. Also decrement k at each step.
     *
     */
    public String removeKdigits(String num, int k) {
        if (k == num.length())
            return "0";

        StringBuilder sb = new StringBuilder();

        for (char c : num.toCharArray()) {
            while (k > 0 && sb.length() != 0 && sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            if (sb.length() > 0 || c != '0')
                sb.append(c);
        }
        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        return sb.length() == 0? "0" : sb.toString();
    }

    public static void main(String[] args) {
        C13_RemoveKDigits obj = new C13_RemoveKDigits();
        System.out.println(obj.removeKdigits("1432219", 3));
        System.out.println(obj.removeKdigits("10200", 1));
        System.out.println(obj.removeKdigits("10", 2));
        System.out.println(obj.removeKdigits("10", 1));
        System.out.println(obj.removeKdigits("9", 1));
        System.out.println(obj.removeKdigits("112", 1));
    }
}
