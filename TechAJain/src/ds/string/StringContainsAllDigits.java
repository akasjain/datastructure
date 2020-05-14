package ds.string;

public class StringContainsAllDigits {
  public static void main(String[] args) {
    String str1 = "12300994";
    System.out.println(isAllDigits(str1));
  }

  private static boolean isAllDigits(String str) {
    char[] arr = str.toCharArray();
    for (char ch : arr) {
      int diff = ch - '0';
      if (!(diff >= 0 && diff <= 9)) {
        return false;
      }
    }
    return true;
  }
}