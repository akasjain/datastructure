package leetcode.challenge.august;

/**
 https://leetcode.com/problems/excel-sheet-column-number/

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 ...
 Example 1:
    Input: "A"
    Output: 1

 Example 2:
    Input: "AB"
    Output: 28

 Example 3:
    Input: "ZY"
    Output: 701
 */
public class AG10_ExcelSheetColumnNumber {

    /**
     * This is base 26 to base 10 conversion
     */
    public int titleToNumber(String s) {
        int result = 0;
        int len = s.length();
        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            result = result * 26 + (ch - 64);
        }
        return result;
    }
}
