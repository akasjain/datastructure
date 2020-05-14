package arrays;

import java.util.Scanner;

public class MajorityElementBST {
	
	public static void main(String[] args) {
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
			System.out.print(majorityElementBST(n, arr));
		}
		sc.close();
	}

	private static long majorityElementBST(long n, long[] arr) {
		Node root = new Node();
		for (long l : arr) {
			
			if(buildBST(root, l, (int) Math.ceil((double)n/2))) {
				return l;
			}
		}
		return -1L;
	}

	private static boolean buildBST(Node root, long l, int majority) {
		
		if(root == null) {
			root = new Node(l, 1);
		} else if (l == root.data) {
			root.count = root.count + 1;
		} else if(l < root.data) {
			buildBST(root.left, l, majority);
		} else if (l > root.data) {
			buildBST(root.right, l, majority);
		}
		
		if(root.count >= majority)
			return true;
		
		return false;
	}
	
}
