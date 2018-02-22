package arrays;

public class RotateArrayAtOnce {

	public static void main(String[] args) {
		int[]a = {5,7,10,16,1,3,22};
		int d=3;
		int n = a.length;
		for (int i : a) {
			System.out.print(i + " ");
		}
		rotate(a, d, n);
		System.out.print("\nRotated Array\n");
		for (int i : a) {
			System.out.print(i + " ");
		}
		
	}

	private static void rotate(int[] a, int d, int n) {
		int[] temp = new int[d];
		for (int i = 0; i < d; i++) {
			temp[i] = a[i];
		}
		for (int i = d; i < n; i++) {
			a[i-d] = a[i];
		}
		for (int i = 0; i < d; i++) {
			a[n-d+i] = temp[i];
		}
	}
}
