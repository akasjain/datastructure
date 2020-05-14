package ds.string;

public class Palindrome {
  public static void main(String[] args) {
    String str = "maddam";
    System.out.println(isPalindrome(str));
  }

  private static boolean isPalindrome(String str) {

    int len = str.length();
    if(len == 0 || len == 1)
      return true;
    else if(str.charAt(0) == str.charAt(len - 1))
      return isPalindrome(str.substring(1, len - 1));

    return false;
  }

  private boolean isAllDigits(String str) {

    char[] arr = str.toCharArray();


    return true;
  }
}
