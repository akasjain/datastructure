package dp;

public class LongestIncreasingSubsequence {

	int[] lis;
	public static void main(String[] args) {

		int[] a = {5,11,8,37,23,50,41,80};
		
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		int length = obj.getLongestSequenceLength(a);
		System.out.println("LIS : " + length);
		
	}

	private int getLongestSequenceLength(int[] a) {
		
		int n = a.length;
		lis = new int[n];
		for (int i = 0; i < n; i++) {
			lis[i] = 1;					// each number is an lis in itself
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if((a[j] < a[i]) && (1 + lis[j] > lis[i])) {
					lis[i] = 1 + lis[j];
				}
			}
		}
		
		// return the max number in lis array
		int max = lis[n-1];
		for (int i = n-2; i >= 0; i--) {
			if(lis[i] < max) {
				break;
			} else if(lis[i] == max) {
				continue;
			} else {
				max = lis[i];
			}
		}
		
		return max;
	}

}
