package ds.array;

public class StringPermutationMatchingWithPattern {
  public static void main(String[] args) {
    System.out.println("Permutation exist: " + StringPermutationMatchingWithPattern.findPermutation("oidbcaf", "abc"));
    System.out.println("Permutation exist: " + StringPermutationMatchingWithPattern.findPermutation("odicf", "dc"));
    System.out.println("Permutation exist: " + StringPermutationMatchingWithPattern.findPermutation("bcdxabcdy", "bcdyabcdx"));
    System.out.println("Permutation exist: " + StringPermutationMatchingWithPattern.findPermutation("aaacb", "abc"));
  }

  public static boolean findPermutation(String str, String pattern) {

    int start = 0, end;
    int patLength = pattern.length();

    boolean[] count = new boolean[26];
    for (char ch : pattern.toCharArray()) {
      int index = ch - 'a';
      count[index] = true;
    }


    for (end = 0; end < str.length(); end++) {

      char ch = str.charAt(end);
      if(!count[ch - 'a']) {
        start = end + 1;
      }

      if(end - start + 1 == patLength) {
        return true;
      }
    }
    return false;
  }
}
