package arrays;

public class ReverseArrayByIteration {

	public static void main(String[] args) {
		int[] a = {5,7,8,13,27,15,44,12,11};
		for (int i : a) {
			System.out.print(i + " ");
		}
		reverseArray(a);
		System.out.println("\nReversed array");
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
	
	private static void reverseArray(int[] a) {
		int size = a.length;
		if(size == 1)
			return;
		int l=0;
		int h=size-1;
		int temp;
		while (l < h) {
			temp = a[l];
			a[l] = a[h];
			a[h] = temp;
			l++;
			h--;
		}
	}
}
