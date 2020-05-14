package ds.array;

class ReplacingOnes {
    public static int findLength(int[] arr, int k) {

        int n = arr.length;
        int start=0, end, maxOnes=0, maxLen = Integer.MIN_VALUE;

        for (end = 0; end < n; end++) {
            if(arr[end] == 1)
                maxOnes++;

            if(end - start + 1 - maxOnes > k) {
                if(arr[start] == 1)
                    maxOnes--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
