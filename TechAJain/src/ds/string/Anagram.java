package ds.string;

/**
 * https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
 */
public class Anagram {
  public static void main(String args[])
  {
    char str1[] = ("geeksforgeeks").toCharArray();
    char str2[] = ("forgeeksgeeks").toCharArray();

    if (areAnagram(str1, str2))
      System.out.println("The two strings are anagram of each other");
    else
      System.out.println("The two strings are not anagram of each other");
  }

  private static boolean areAnagram(char[] str1, char[] str2) {
    int[] count = new int[256];
    int n1 = str1.length;
    int n2 = str2.length;

    if (n1 != n2)
      return false;

    for (int i = 0; i<n1 && 1<n2; i++) {
      count[str1[i]]++;
      count[str2[i]]--;
    }

    for(int num : count) {
      if(num != 0)
        return false;
    }

    return true;
  }
}
