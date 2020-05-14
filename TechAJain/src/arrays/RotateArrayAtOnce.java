package arrays;

import java.util.Scanner;

public class RotateArrayAtOnce {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numOfTest = sc.nextInt();
		for(int i=0; i<numOfTest; i++) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			if(d > n) {
				d = d%n;
			}
			int[] arr = new int[n];
			int j = 0;
			while(j < n) {
				arr[j] = sc.nextInt();
				j++;
			}
		
			leftRotate(arr, d, n);
			System.out.print("\nRotated Array\n");
			
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();			
		}
		sc.close();
	}

	private static void leftRotate(int[] a, int d, int n) {
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
