package leetcode.challenge.april;

/**
 https://leetcode.com/problems/valid-parenthesis-string/

 Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

 Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 Any right parenthesis ')' must have a corresponding left parenthesis '('.
 Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 An empty string is also valid.

 Example 1:
    Input: "()"
    Output: True

 Example 2:
    Input: "(*)"
    Output: True

 Example 3:
    Input: "(*))"
    Output: True

 Note: The string size will be in the range [1, 100].
 */
public class C16_ValidParenthesisString {
    public boolean checkValidString(String s) {

        int balance = 0;
        if(s.length() < 1)
            return true;

        /*
        First loop to check closing parenthesis match
         */
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')')
                balance --;
            else
                balance++;

            if(balance < 0)
                return false;
        }
        if(balance == 0)
            return true;   // all matched

        /*
        Second loop to check opening parenthesis
         */
        balance = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if(s.charAt(i) == '(')
                balance--;
            else
                balance++;

            if(balance < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        C16_ValidParenthesisString obj = new C16_ValidParenthesisString();
        String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        System.out.println(obj.checkValidString(s));
        System.out.println(obj.checkValidString("((*))))"));
        System.out.println(obj.checkValidString("((((*))"));
        System.out.println(obj.checkValidString("((((**))"));
        System.out.println(obj.checkValidString("((((**))"));

    }
}
