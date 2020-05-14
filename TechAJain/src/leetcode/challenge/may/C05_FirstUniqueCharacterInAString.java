package leetcode.challenge.may;

/**
 Week1 May5

 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Example 1:
    s = "leetcode"
    return 0.

 Example 2:
    s = "loveleetcode",
    return 2.

 Note: You may assume the string contain only lowercase letters.
 */
public class C05_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if(s == null || s == "")
            return -1;

        int[] count = new int[26];

        for(char ch : s.toCharArray()) {
            if(count[ch - 'a'] > 0) {
                count[ch - 'a'] += 1;
            } else {
                count[ch - 'a'] = 1;
            }
        }

        for(int i = 0; i < s.length(); i++) {
            if(count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        C05_FirstUniqueCharacterInAString obj = new C05_FirstUniqueCharacterInAString();
        System.out.println(obj.firstUniqChar("leetcode"));
        System.out.println(obj.firstUniqChar("loveleetcode"));
        System.out.println(obj.firstUniqChar(""));
        System.out.println(obj.firstUniqChar("aa"));
    }
}
