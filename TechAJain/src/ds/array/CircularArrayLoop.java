package ds.array;

class CircularArrayLoop {

    public static boolean loopExists(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean forward = arr[i] >= 0;
            int slow = i, fast = i;
            do {
                slow = findNextIndex(arr, forward, slow);
                fast = findNextIndex(arr, forward, fast);
                if(fast != -1)
                    fast = findNextIndex(arr, forward, fast);

            } while(slow != -1 && fast != -1 && slow != fast);
            if(slow == fast)
                return true;
        }
        return false;
    }

    private static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean currentDirection = arr[currentIndex] >= 0;
        int nextIndex;
        if(currentDirection != isForward)
            return -1;
        nextIndex = (currentIndex + arr[currentIndex]) % arr.length;
        if(nextIndex < 0)
            nextIndex += arr.length;
        if(nextIndex == currentIndex)
            return -1;

        return nextIndex;

    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}
