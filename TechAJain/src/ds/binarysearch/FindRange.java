package ds.binarysearch;

class FindRange {

    public static int[] findRange(int[] arr, int key) {


        int len = arr.length;
        int start = 0, end = len - 1, mid = 0;

        while(start <= end) {
            mid = start + (end - start) / 2;
            if(key == arr[mid])
                break;

            if(key < arr[mid]) {
                end = start - 1;
            } else {
                start = mid + 1;
            }
        }

        if(arr[mid] != key)
            return new int[] { -1, -1 };

        int left = mid, right = mid;
        while(left > 0 && arr[left - 1] == key)
            left--;
        while(right < len-1 && arr[right + 1] == key)
            right++;


        return new int[] {left, right};
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
