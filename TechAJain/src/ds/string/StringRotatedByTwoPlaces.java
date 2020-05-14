package ds.string;

/**
 * https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places/0
 */
public class StringRotatedByTwoPlaces {
  public static void main(String[] args) {
    String s1 = "amazon";
    String clock = "onamaz";
    String antiClock = "azonam";

    boolean isRotated = areStringRoratedByTwoPlaces(s1, clock);
    System.out.println(isRotated);

    isRotated = areStringRoratedByTwoPlaces(s1, antiClock);
    System.out.println(isRotated);

  }

  private static boolean areStringRoratedByTwoPlaces(String s1, String s2) {

    if(s1.length() != s2.length())
      return false;

    String clockwise = s2.substring(2) + s2.substring(0,2);
    String antoClockWise = s2.substring(s2.length() - 2) + s2.substring(0, s2.length() - 2);

    return s1.equals(clockwise) || s1.equals(antoClockWise);
  }
}
