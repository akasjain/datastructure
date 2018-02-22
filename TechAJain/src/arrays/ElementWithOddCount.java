package arrays;

public class ElementWithOddCount {

	public static void main(String[] args) {
		int[] a = {2,3,4,1,7,3,2,1,4,7,1};
		int num = getNumberWithOddCount(a);
		if(num != -1) {
			System.out.printf("Found number : %d", num);
		} else
			System.out.println("No such number found");
	}

	private static int getNumberWithOddCount(int[] a) {
		int size = 	a.length;
		int num = 0;
		for (int i = 0; i < a.length; i++) {
			num = num ^ a[i];
			System.out.println(num);
		}
		return num;
	}

}
