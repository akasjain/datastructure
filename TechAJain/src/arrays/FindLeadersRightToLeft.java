package arrays;

public class FindLeadersRightToLeft {

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
		int k=0;
		int max=a[n-1];
		int[] leaders = new int[n];
		leaders[k++] = a[n-1];
		for (int i = n-1; i >= 0; i--) {
			if(a[i] > max) {
				leaders[k++] = a[i];
				max = a[i];
			}
		}
		return leaders;
	}

}
