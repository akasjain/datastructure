package ds.string;

public class RemoveAdjacentDuplicates {
  public static void main(String[] args) {
    String str = "abccaaabdd"; // O/P should be abcabd
    String withoutDup = removeAdjacentDuplicates(str);
    System.out.println(withoutDup);
  }

  private static String removeAdjacentDuplicates(String str) {

    if(str.length() <= 1)
      return str;
    if(str.charAt(0) == str.charAt(1)) {
      return removeAdjacentDuplicates(str.substring(1));
    } else {
      return str.charAt(0) + removeAdjacentDuplicates(str.substring(1));
    }

  }
}
