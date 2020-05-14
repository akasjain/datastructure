package dp;

public class CoinChangeProblem {

	public static void main(String[] args) {

		int S[] = {1,2,3};
		int n=5;
		int m = S.length;
		
		CoinChangeProblem c = new CoinChangeProblem();
		int result = c.getNumberOfWaysToMakeSum(S,m,n);
		System.out.println("Number of ways : " + result);
	}

	private int getNumberOfWaysToMakeSum(int[] s, int m, int n) {

		if(n == 0)
			return 1;

		int[] t = new int[n+1];
		for (int i = 0; i < t.length; i++)
			t[i] = 0;
		t[0] = 1;

		for(int i=0; i < m; i++) {
			for(int j=s[i]; j<=n; j++) {
				t[j] = t[j] + t[j-s[i]];
			}
		}

		return t[n];
	}

}
