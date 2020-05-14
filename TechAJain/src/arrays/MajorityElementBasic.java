package arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MajorityElementBasic {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfTest = sc.nextInt();
		for(int i=0; i<numOfTest; i++) {
			long n = sc.nextLong();
			long[] arr = new long[(int) n];
			int j = 0;
			while(j < n) {
				arr[j] = sc.nextLong();
				j++;
			}
			System.out.print(majorityElementBasic(n, arr));
		}
		sc.close();
	}
	
	private static long majorityElementBasic(long n, long[] arr) {
		
		Set<Long> checked = new HashSet<>();
		for (int i = 0; i < Math.ceil(n/2); i++) {
			int count=0;
			for (int j = i; j < n && !checked.contains(arr[i]); j++) {
				if(arr[i] == arr[j]) {
					count++;
				}
			}
			if(count > n/2) {
				return arr[i];
			}
			checked.add(arr[i]);
		}
		return -1L;
	}
}
