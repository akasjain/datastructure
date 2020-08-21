package leetcode.challenge.august;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 824. Goat Latin
 https://leetcode.com/problems/goat-latin/

 A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 The rules of Goat Latin are as follows:

 If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 For example, the word 'apple' becomes 'applema'.

 If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 For example, the word "goat" becomes "oatgma".

 Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 Return the final sentence representing the conversion from S to Goat Latin.

 Example 1:
    Input: "I speak Goat Latin"
    Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

 Example 2:
    Input: "The quick brown fox jumped over the lazy dog"
    Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 */
public class AG19_GoatLatin {
    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        String[] words = S.split(" ");
        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'));

        for(int i = 0; i < words.length; i++) {
            StringBuilder word = new StringBuilder(words[i]);
            if(!vowels.contains(word.charAt(0))) {
                word.append(word.charAt(0));
                word.deleteCharAt(0);
            }

            word.append("ma");
            for(int j = 0; j <= i; j++) {
                word.append("a");
            }
            word.append(" ");
            sb.append(word.toString());
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
