package arrays;

public class SearchInSortedRotatedArray {

	public static void main(String[] args) {
		int[] a = {16,21,27,3,5,9,13};
		int size = a.length;
		int num = 17;
		int index = -1;
		int pivot = findPivot(a);

		if (pivot == -1) {
			index = binarySearch(a, 0, size - 1, num);
		} else if(num <= a[size-1]) {
			index = binarySearch(a, pivot+1, size-1, num);
		} else {
			index = binarySearch(a, 0, pivot, num);
		}
		if(index != -1) {
			System.out.printf("Number found at %d", index);
		} else {
			System.out.println("Number not found");
		}
	}
	
	private static int findPivot(int[] a) {
		int size = a.length;
		for (int i = 1; i < size-1; i++) {
			if((a[i-1] < a[i]) && (a[i+1] < a[i])) {
				return i;
			}
		}
		return -1; //no pivot found, already in sorted order
	}
	
	private static  int binarySearch(int[] a, int l, int h, int num) {
		int mid = (l+h)/2;
		while (l <= mid) {
			if (num == a[mid]) {
				return mid;
			} else if(num < a[mid]) {
				h = mid -1;
			} else {
				l = mid + 1;
			}
			mid = (l + h)/2;
		}
		return -1;
	}
}


