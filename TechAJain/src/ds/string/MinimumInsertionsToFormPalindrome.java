package ds.string;

/**
 * https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
 */
public class MinimumInsertionsToFormPalindrome {

  public static void main(String args[])
  {
    String str= "geeks";
    System.out.println(findMinInsertions(str, 0, str.length()-1));
  }

  private static int findMinInsertions(String str, int low, int high) {

    if(low > high)
      return Integer.MIN_VALUE;
    if(low == high)
      return 0;
    if(low == high-1)
      return str.charAt(low)==str.charAt(high) ? 0 : 1;

    return str.charAt(low)==str.charAt(high) ? findMinInsertions(str, low+1, high-1) :
      Math.min(findMinInsertions(str, low+1, high), findMinInsertions(str, low, high-1)) + 1;
  }
}
