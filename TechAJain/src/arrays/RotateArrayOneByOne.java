package arrays;

public class RotateArrayOneByOne {

	public static void main(String[] args) {
		int[]a = {5,7,10,16,1,3,22};
		int d=2;
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
		int count=0,temp;
		while(count<d) {
			temp = a[0];
			for (int i = 1; i < n; i++) {
				a[i-1] = a[i];
			}
			a[n-1] = temp;
			count++;
		}
	}
}
