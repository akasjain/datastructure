package arrays;

public class SumOfElement2 {

	public static void main(String[] args) {
		int a[] = {1, 4, 45, 6, 10, 8};
		int sum = 18;
		
		int num = getNumbers(a, sum);
		if(num != -1) {
			System.out.printf("Found numbers : %d & %d", num, sum-num);
		} else
			System.out.println("No such numbers found");
	}

	private static int getNumbers(int[] a, int sum) {
		int size = a.length;
		boolean[] m = new boolean[100000];
		for(int i=0; i<size; i++) {
			int temp = sum - a[i];
			if(temp >= 0 && m[temp]) {
				return a[i]; 
			} else if(temp >= 0){
				m[a[i]] = true;
			}
		}
		return -1;
	}

}
