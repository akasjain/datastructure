package leetcode.challenge.april;

/**
 Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 Note that after backspacing an empty text, the text will continue empty.

 Example 1:
    Input: S = "ab#c", T = "ad#c"
    Output: true
    Explanation: Both S and T become "ac".

 Example 2:
    Input: S = "ab##", T = "c#d#"
    Output: true
    Explanation: Both S and T become "".

 Example 3:
    Input: S = "a##c", T = "#a#c"
    Output: true
    Explanation: Both S and T become "c".

 Example 4
    Input: S = "a#c", T = "b"
    Output: false
    Explanation: S becomes "c" while T becomes "b".

 Note:
 1 <= S.length <= 200
 1 <= T.length <= 200
 S and T only contain lowercase letters and '#' characters.
 */

public class C09_BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int sidx = S.length() - 1;
        int tidx = T.length() - 1;

        while(sidx >= 0 || tidx >= 0) {
            int i1 = getNextValidChar(S, sidx);
            int i2 = getNextValidChar(T, tidx);

            if(i1 < 0 && i2 < 0)
                return true;
            if(i1 < 0 || i2 < 0)
                return false;
            if(S.charAt(i1) != T.charAt(i2))
                return false;

            sidx = i1 - 1;
            tidx = i2 - 1;
        }
        return true;

    }
    private int getNextValidChar(String str, int index) {
        int backspaceCount = 0;
        while(index >= 0) {
            if (str.charAt(index) == '#') // found a backspace character
                backspaceCount++;
            else if (backspaceCount > 0) // a non-backspace character
                backspaceCount--;
            else
                break;

            index--;
        }

        return index;
    }

    public static void main(String[] args) {
        C09_BackspaceStringCompare obj = new C09_BackspaceStringCompare();
        System.out.println(obj.backspaceCompare("ab#c", "ad#c"));
        System.out.println(obj.backspaceCompare("ab##", "c#d#"));
        System.out.println(obj.backspaceCompare("a##c", "#a#c"));
        System.out.println(obj.backspaceCompare("a#c", "b"));
        System.out.println(obj.backspaceCompare("#", "#"));
        System.out.println(obj.backspaceCompare("a", "a"));
    }
}
