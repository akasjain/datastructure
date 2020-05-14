package ds.string;

/**
 * https://www.geeksforgeeks.org/converting-roman-numerals-decimal-lying-1-3999/
 */
public class RomanToInteger {
  public static void main(String[] args) {
    RomanToInteger ob = new RomanToInteger();

    // Considering inputs given are valid
    String str = "XXVI";
    System.out.println("Integer form of Roman Numeral is " + ob.romanToDecimal(str));
  }

  private int romanToDecimal(String str) {

    int result = 0;
    int len = str.length();

    for (int i = 0; i < len; i++) {

      int n1 = value(str.charAt(i));
      if(i+1 < len) {
        int n2 = value(str.charAt(i+1));
        if(n1 >= n2) {
          result += n1;
        } else {
          result += n2 - n1;
          i++;
        }
      } else {
        result += n1;
      }

    }
    return result;
  }

  int value(char r)
  {
    if (r == 'I')
      return 1;
    if (r == 'V')
      return 5;
    if (r == 'X')
      return 10;
    if (r == 'L')
      return 50;
    if (r == 'C')
      return 100;
    if (r == 'D')
      return 500;
    if (r == 'M')
      return 1000;
    return -1;
  }
}
