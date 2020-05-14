package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindLeadersRightToLeft {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int i=0;
			int n=sc.nextInt();
			int[] a=new int[n];
			while(i<n){
				a[i]=sc.nextInt();
				i++;
			}
			List<Integer> leaders = findLeaders(a, n);
			Collections.reverse(leaders);
			if(leaders != null) {
				leaders.stream().forEach(o -> System.out.print(o + " "));
			}
			System.out.println("");
		}
		sc.close();
	}
	
	@SuppressWarnings("unchecked")
	private static List<Integer> findLeaders(int[] a, int n) {
		int max = a[n-1];
		List<Integer> leaders = new ArrayList<>(n);
		leaders.add(a[n-1]);
		for (int i = n-2; i >= 0; i--) {
			if(a[i] >= max) {
				leaders.add(a[i]);
				max = a[i];
			}
		}
		return leaders;
	}

}
