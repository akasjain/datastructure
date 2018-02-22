package arrays;

public class FindLeaders {

	public static void main(String[] args) {
		int[] a =  {16, 17, 4, 3, 5, 2};
		int[] leaders = findLeaders(a, a.length);
		if(leaders != null) {
			for (int i : leaders) {
				if (i==0) {
					continue;
				}
				System.out.println(i + ", ");
			}
		}
	}
	
	private static int[] findLeaders(int[] a, int n) {
		
		int[] leaders = new int[n];
		int k = 0;
		for (int i = 0; i < n-1; i++) {
			int lead = 1;
			for (int j = i + 1; j < n; j++) {
				if(a[j] > a[i]) {
					lead = 0;
					break;
				}
			}
			if(lead == 1) {
				leaders[k++] = a[i];
			}
		}
		leaders[k++] = a[n-1];
		return leaders;
	}

}
