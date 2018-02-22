package arrays;

public class SumOfElement1 {

	public static void main(String[] args) {
		int a[] = {1,4,6,8,10,45};
		int sum = 16;
		
		int num = getNumbers(a, sum);
		if(num != -1) {
			System.out.printf("Found numbers : %d & %d", num, sum-num);
		} else
			System.out.println("No such numbers found");
	}
	
	public static int getNumbers(int[] a, int sum) {
		int size = a.length;
		int l=0;
		int r=size-1;
		while (l < r) {
			int currentSum = a[l] + a[r];
			if(currentSum == sum) {
				return a[l]; 
			} else if(currentSum < sum) {
				l++;
			} else {
				r--;
			}
		}
		return -1;
	}
}
