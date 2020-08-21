package leetcode.challenge.august;

/**
 125. Valid Palindrome
 https://leetcode.com/problems/valid-palindrome/

 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Note: For the purpose of this problem, we define empty string as valid palindrome.

 Example 1:
    Input: "A man, a plan, a canal: Panama"
    Output: true

 Example 2:
    Input: "race a car"
    Output: false
 */
public class AG03_ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left <= right || right-left > 1){
            if( !Character.isLetterOrDigit( s.charAt(left) ) ) left++;
            else if(!Character.isLetterOrDigit( s.charAt(right) ) ) right--;
            else if( Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right)) ) return false;
            else {
                left++;
                right--;
            }
        }
        return true;

    }
}
