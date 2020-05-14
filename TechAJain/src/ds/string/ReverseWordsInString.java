package ds.string;

public class ReverseWordsInString {

  static final char DELIM = ' ';
  public static void main(String[] args) {
    String str = "I have an elegant \t mother that just showed us";
    String reverse = reverse(str);
    System.out.println(reverse);
    System.out.println(str.length() == reverse.length());
  }

  private static String reverse(String str) {
    StringBuilder sb = new StringBuilder();
    if(str == null || str.length() == 0)
      return str;

    int i = 0;
    while(i<str.length() && str.charAt(i) != DELIM) {
      sb.append(str.charAt(i));
      i++;
    }
    if(i == str.length())
      return sb.toString();

    return reverse(str.substring(i+1)) + DELIM + sb.toString();
  }
}
