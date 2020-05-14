package ds.array.leetcode;

public class RemoveDuplicates {

  public static void main(String[] args) {
    int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
    System.out.println(RemoveDuplicates.remove(arr));

    arr = new int[] { 2, 2, 2, 11 };
    System.out.println(RemoveDuplicates.remove(arr));
  }

  private static int remove(int[] arr) {
    int nextNonDup = 1;
    for (int i = 1; i < arr.length; i++) {

      if(arr[i-1] != arr[i]) {
        arr[nextNonDup] = arr[i];
        nextNonDup++;
      }

    }

    return nextNonDup;
  }

}
