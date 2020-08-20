package leetcode.challenge.august;

/**
 https://leetcode.com/problems/detect-capital/

 Given a word, you need to judge whether the usage of capitals in it is right or not.

 We define the usage of capitals in a word to be right when one of the following cases holds:

 All letters in this word are capitals, like "USA".
 All letters in this word are not capitals, like "leetcode".
 Only the first letter in this word is capital, like "Google".
 Otherwise, we define that this word doesn't use capitals in a right way.

 Example 1:
    Input: "USA"
    Output: True

 Example 2:
    Input: "FlaG"
    Output: False
 Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class AG01_DetectCapital {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if(len == 1)
            return true;

        boolean allUpperCase = true;
        boolean allLowerCase = true;

        char[] chars = word.toCharArray();
        for(int i = 1; i < chars.length; i++) {

            allUpperCase = allUpperCase && !Character.isLowerCase(chars[i]);
            allLowerCase = allLowerCase && Character.isLowerCase(chars[i]);
        }

        if(allLowerCase || (allUpperCase && !Character.isLowerCase(chars[0])))
            return true;

        return false;
    }

    public static void main(String[] args) {
        AG01_DetectCapital obj = new AG01_DetectCapital();
        System.out.println(obj.detectCapitalUse("USA"));
        System.out.println(obj.detectCapitalUse("FlaG"));
        System.out.println(obj.detectCapitalUse("abacus"));
        System.out.println(obj.detectCapitalUse("abaCus"));
    }
}
