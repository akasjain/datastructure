package leetcode.challenge.april;

/**
 You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 direction can be 0 (for left shift) or 1 (for right shift).
 amount is the amount by which string s is to be shifted.
 A left shift by 1 means remove the first character of s and append it to the end.
 Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 Return the final string after all operations.

 Example 1:
    Input: s = "abc", shift = [[0,1],[1,2]]
    Output: "cab"
    Explanation:
     [0,1] means shift to left by 1. "abc" -> "bca"
     [1,2] means shift to right by 2. "bca" -> "cab"

 Example 2:
    Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
    Output: "efgabcd"
    Explanation:
     [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
     [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
     [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
     [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 */
public class C14_PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        int direction;
        int shiftAmount = 0;
        int len = s.length();
        String s1 = "";
        String s2 = "";

        for(int[] row : shift) {
            direction = row[0];
            if(direction == 0)
                shiftAmount -= row[1];
            else
                shiftAmount += row[1];

        }

        if(shiftAmount < 0) {
            shiftAmount = Math.abs(shiftAmount);
            shiftAmount = shiftAmount % len;
            s1 = s.substring(shiftAmount);
            s2 = s.substring(0, shiftAmount);
        } else if(shiftAmount > 0){
            shiftAmount = shiftAmount % len;
            s1 = s.substring(len - shiftAmount);
            s2 = s.substring(0, len - shiftAmount);
        } else {
            return s;
        }

        return s1 + s2;
    }

    public static void main(String[] args) {
        C14_PerformStringShifts obj = new C14_PerformStringShifts();
        int[][] shift = {{0,1},{1,2}};
        System.out.println(obj.stringShift("abc", shift));

        shift = new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}};
        System.out.println(obj.stringShift("abcdefg", shift));

        shift = new int[][]{{1,8},{1,4},{1,3},{1,6},{0,6},{1,4},{0,2},{0,1}};
        System.out.println(obj.stringShift("yisxjwry", shift));
    }
}
