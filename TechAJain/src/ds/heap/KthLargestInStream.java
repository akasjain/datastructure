package ds.heap;

import java.util.PriorityQueue;

public class KthLargestInStream {

  PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // minHeap
  int size;

  public static void main(String[] args) {
    int[] A = {23, 10, 15, 70, 5, 80, 100, 10, 20, 11, 75, 50, 40, 110, 120};
    int k = 3;
    int num;
    KthLargestInStream kthLargestInStream = new KthLargestInStream();
    
    
    for (int i = 0; i < A.length; i++) {
      num = kthLargestInStream.findKthLargest(k, A[i]);
      if(num != Integer.MIN_VALUE)
        System.out.println(A[i] + " " + num);
    }


  }

  private int findKthLargest(int k, int num) {

    if(size < k) {
      minHeap.add(num);
      size++;
      return Integer.MIN_VALUE;
    }

    if(num > minHeap.peek()) {
      minHeap.poll();
      minHeap.add(num);
    }
    return minHeap.peek();
  }


}
