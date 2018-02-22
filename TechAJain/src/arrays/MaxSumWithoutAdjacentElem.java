package arrays;

public class MaxSumWithoutAdjacentElem {

	public static void main(String[] args) {
		int[] a = {5,5,10,50,40,35};
		int maxSum = getMaxSum(a, a.length);
		System.out.println("Maximum sum : " + maxSum);
	}
	
	/**
	 * At every element we maintain two numbers incl and excl.
	 * incl is computed by adding excl of previous plus current excl + a[i]
	 * excl is computed among maximum of incl and excl of previous element.
	 * @param a
	 * @param n
	 * @return
	 */
	private static int getMaxSum(int[] a, int n) {
		int incl = a[0];
		int excl = 0;
		int excl_new;
		for (int i = 1; i < n; i++) {
			excl_new = incl > excl ? incl:excl;
			incl = excl + a[i];
			excl = excl_new;
		}
		return incl > excl ? incl:excl;
	}

}
