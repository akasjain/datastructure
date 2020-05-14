package arrays;

class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int len = arr.length;
        int[] squares = new int[len];
        int index = 0;

        int left = 0, right = 0;
        for (left = 0; left < len-1; left++) {
            if(arr[left] == 0 || (arr[left] < 0 && arr[left+1] > 0))
                break;
        }
        right = left + 1;
        while(left >= 0 || right < len) {

            if(Math.abs(arr[left]) <= Math.abs(arr[right])) {
                squares[index++] = (int)Math.pow(arr[left], 2);
                left --;
            } else {
                squares[index++] = (int) Math.pow(arr[right], 2);
                right++;
            }
            if(left == -1) {
                //write all from right
                while(right != len) {
                    squares[index++] = (int) Math.pow(arr[right++], 2);
                }
                break;
            }
            if(right == len) {
                //write all from left
                while(left != -1) {
                    squares[index++] = (int)Math.pow(arr[left--], 2);
                }
                break;
            }
        }

        return squares;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}