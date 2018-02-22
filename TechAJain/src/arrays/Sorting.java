package arrays;

import org.junit.Test;

public class Sorting {

	public static int[] selectionSort(int[] A) {
		int n = A.length;

		long start = System.currentTimeMillis();

		for (int i = 0; i < n-1; i++) {
			int minIndex = i;
			for (int j = i+1; j < n; j++) {
			 	if(A[minIndex] > A[j]) {
					minIndex = j;
				}
			}
			swap(A,i,minIndex);
		}
		long end = System.currentTimeMillis();
		System.out.println("\nTime taken in selection sort = " + (end-start));
		return A;
	}
	
	public static int[] bubbleSort(int[] A) {
		int n = A.length;
		long start = System.currentTimeMillis();

		for (int i = 0; i < n-1; i++) {
			
			boolean flag = true;
			
			for (int j = 0; j < n-1-i; j++) {
				if(A[j] > A[j+1]) {
					swap(A, j, j+1);
					flag = false;
				}
			}
			if(flag)
				break;
		}
		long end = System.currentTimeMillis();
		System.out.println("\nTime taken in bubble sort = " + (end-start));

		return A;
	}
	
	public static int[] insertionSort(int[] A) {
		int n = A.length;
		//at any time there are two subsets - sorted and unsorted.
		//we pick one element and place it in sorted subarray (by shifting positions)
		long start = System.currentTimeMillis();

		for (int i = 1; i < n; i++) {
			int j=i;
			while((j>0) && (A[j] < A[j-1])) {
				swap(A, j, j-1);
				j--;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("\nTime taken in insertion sort = " + (end-start));

		return A;
	}
	
	public static int[] mergeSort(int[] A) {
		//base condition
		//mergesort first half
		//mergesort second half
		//combine/merge
		int n = A.length - 1;
		
		if(n == 0) {
			return null ;
		}
		
		int mid = n/2;
		System.out.println("N : " + n + " Mid : " + mid);
		int[] left = new int[mid+1];
		int[] right = new int[n-mid];
		
		
		for (int i = 0; i <= mid; i++) {
			left[i] = A[i];
		}
		
		for (int i = mid+1; i <= n; i++) {
			right[i-mid-1] = A[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(A,left,right);
		
		return A;
	}

	private static void merge(int[] A, int[] left, int[] right) {
		int leftLen = left.length;
		int rightLen = right.length;
		
		int i=0,j=0,k=0;
		
		while(i<leftLen && j<rightLen) {
			if(left[i] <= right[j]) {
				A[k++] = left[i++];
			} else {
				A[k++] = right[j++];
			}
		}
		while(i<leftLen) {
			A[k++] = left[i++];
		}
		while(j<rightLen) {
			A[k++] = right[j++];
		}
	}
	
	public static int[] quicksort(int[] A, int start, int end) {
		//select a pivot element
		int n = A.length;
		int pivotIndex = end;
		
		//base condition
		if(start >= end) {
			return null;
		}
		//partition array - pass pivot and return position
		pivotIndex = partition(A, pivotIndex);
		//of pivot with element less than pivot to left and rest right
		//
		//quicksort left to pivot
		quicksort(A, start, pivotIndex - 1);//A,0,3
		quicksort(A, pivotIndex + 1, end);//A,5,5
		//quicksort right to pivot
		
		
		
		return A;
		
	}
	
	private static int partition(int[] A, int pivotIndex) {

		int n = A.length;
		int indexOfNumLessThanPivot=0;
		for (int i = 0; i < n; i++) {
			if(A[i] < A[pivotIndex]) {
				swap(A, i, indexOfNumLessThanPivot);
				indexOfNumLessThanPivot++;
			}
		}
		swap(A, indexOfNumLessThanPivot, pivotIndex);
		return indexOfNumLessThanPivot;
	}

	private static void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
	
	@Test
	public void testSelectionSort() {
		int a[] = {2,5,1,-7,-3,9,1,-3};
		Sorting.selectionSort(a);
		System.out.println("Printing");
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
	
	@Test
	public void testBubbleSort() {
		int a[] = {2,5,1,-7,-3,9};
		Sorting.bubbleSort(a);
		System.out.println("Printing");
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
	
	@Test
	public void testInsertionSort() {
		int a[] = {2,5,1,-7,-3,9,1,-3};
		Sorting.insertionSort(a);
		System.out.println("Printing");
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
	
	@Test
	public void testMergeSort() {
		int a[] = {2,5,1,-7,-3,9,1,-3};
		a = Sorting.mergeSort(a);
		System.out.println("Printing");
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
	
	@Test
	public void testQuickSort() {
		int a[] = {2,5,1,-7,-3,9,11,6,89,33,65,78,112};
		a = Sorting.quicksort(a, 0, a.length-1);
		System.out.println("Printing");
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}
