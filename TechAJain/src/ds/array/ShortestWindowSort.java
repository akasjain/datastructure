package ds.array;

class ShortestWindowSort {

    public static int sort(int[] arr) {
        int len = arr.length;
        int left = 0, right = len - 1;

        while(left < len && arr[left] <= arr[left + 1]) {
            left++;
        }
        while(right >= 0 && arr[right-1] <= arr[right]) {
            right--;
        }

        //find min and max in the subarray
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = left; i <= right; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        while(left > 0 && arr[left - 1] > min) {
            left--;
        }
        while(right < len-1 && arr[right + 1] < max) {
            right++;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));
    }
}