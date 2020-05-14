package ds.string;

public class Permutations {


  public static void main(String[] args) {
    String str = "abc";
    permute(str, str.length());
  }

  private static void permute(String str, int length) {

    if(length == 1) {
      System.out.println(str);
      return;
    }

    for (int i = 0; i < length; i++) {
      str = swap(str, i, length-1);
      permute(str, length - 1);
      str = swap(str, i, length-1);
    }
  }

  private static String swap(String str, int i, int j) {
    char[] strToChar = str.toCharArray();
    char temp = strToChar[i];
    strToChar[i] = strToChar[j];
    strToChar[j] = temp;

    return String.valueOf(strToChar);
  }

}
