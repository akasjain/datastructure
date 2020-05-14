package ds.string;

public class ConvertStringToInt {
  public static void main(String[] args) {
    String str = "1124a4";
    int num = 0;
    try {
      num = convertStringToInt(str);
    } catch (IllegalInputException e) {
      System.out.println("Exception occured: " + e.getMessage());
      return;
    }
    System.out.println(num);
  }

  private static int convertStringToInt(String str) throws IllegalInputException {

    char[] arr = str.toCharArray();
    int sum = 0;
    for(char ch : arr) {
      int num = ch - '0';
      if(num < 0 || num > 9) {
        throw new IllegalInputException("Input contains other than digits");
      }
      sum = sum*10 + num;
    }
    return sum;
  }
}

class IllegalInputException extends Exception {
  IllegalInputException(String message) {
    super(message);
  }

}
