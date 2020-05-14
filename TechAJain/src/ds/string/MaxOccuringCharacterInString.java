package ds.string;

public class MaxOccuringCharacterInString {

  public static char maxOccuringChar(String str) {

    char[] charArray = str.toCharArray();
    int[] arr = new int[256];
    int maxCount = Integer.MIN_VALUE;
    char maxChar = charArray[0];
    for (char ch : charArray) {
      arr[ch]++;
      if(arr[ch] > maxCount) {
        maxCount = arr[ch];
        maxChar = ch;
      }
    }
    return  maxCount > 1 ? maxChar : null;
  }

  public static void main(String[] args) {
    String str = "bracadabraa";
    System.out.println(maxOccuringChar(str));
  }
}
