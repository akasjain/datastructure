package dp;

public class MinimumNumberOfCoins {

	static int MAX = 10000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int S[] = {1,2,3};
		int n=0;
		int m = S.length;
		
		MinimumNumberOfCoins obj = new MinimumNumberOfCoins();
		int result = obj.getMinCount(S,m,n);
		System.out.println("Minimum number of coins needed : " + result);

		
	}

	/**
	 * 
	 * @param s - value of each coin stored in array
	 * @param m - number of coins
	 * @param n - number for which minimum number of coins needed
	 * @return 	- number of coins needed for number n	
	 */
	private int getMinCount(int[] s, int m, int n) {

		if(n <= 0) //no coin is needed to make sum <= 0
			return 0;
		int[] t = new int[n+1];
		for (int i = 0; i < t.length; i++) {
			t[i] = MAX;							// initialize table with large value to compare with minimum ones
		}
		t[0] = 0;
		
		for(int i = 1; i <= n; i++) {
			int temp_result;
			for (int j = 0; j < m; j++) {
				if(i >= s[j]) {
					temp_result = 1 + t[i-s[j]];
					if(temp_result < t[i]) {
						t[i] = temp_result;
					}
						
				}
			}
		}
		
		
		return t[n];
	}

}
