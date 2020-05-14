package ds.heap;

public class MedianInStream {


  int[] maxHeap;
  int[] minHeap;
  int sizeMaxHeap;
  int sizeMinHeap;
  int median;
  MaxHeap maxHeapUtil = new MaxHeap();
  MinHeap minHeapUtil = new MinHeap();

  public MedianInStream(int MAX) {
    this.maxHeap = new int[MAX];
    this.minHeap = new int[MAX];
  }

  public static void main(String[] args) {
    int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
    int size = A.length;

    MedianInStream medianInStream = new MedianInStream(20);
    medianInStream.printMedian(A, size);


  }

  public void printMedian(int[] A, int size) {

    for (int i = 0; i < size; i++) {
      median = getMedian(A[i]);
      System.out.print(median + " ");
    }
  }

  private int getMedian(int num) {

    switch(sizeMaxHeap - sizeMinHeap) {
      case 1:
        if(num <= median) {
          minHeapUtil.insert(minHeap, sizeMinHeap++, maxHeapUtil.extractMax(maxHeap, sizeMaxHeap));
          maxHeapUtil.insert(maxHeap, sizeMaxHeap++, num);
        } else {
          minHeapUtil.insert(minHeap, sizeMinHeap++, num);
        }
        median = (maxHeapUtil.getMax(maxHeap, sizeMaxHeap) + minHeapUtil.getMin(minHeap, sizeMinHeap)) / 2;
        break;

      case 0:
        if(num <= median) {
          maxHeapUtil.insert(maxHeap, sizeMaxHeap++, num);
          median = maxHeapUtil.getMax(maxHeap, sizeMaxHeap);
          break;
        } else {
          minHeapUtil.insert(minHeap, sizeMinHeap++, num);
          median = minHeapUtil.getMin(minHeap, sizeMinHeap);
          break;
        }

      case -1:
        if(num <= median) {
          maxHeapUtil.insert(maxHeap, sizeMaxHeap++, num);
        } else {
          maxHeapUtil.insert(maxHeap, sizeMaxHeap++, minHeapUtil.extractMin(minHeap, sizeMinHeap));
          minHeapUtil.insert(minHeap, sizeMinHeap++, num);
        }
        median = (maxHeapUtil.getMax(maxHeap, sizeMaxHeap) + minHeapUtil.getMin(minHeap, sizeMinHeap)) / 2;
        break;

    }

    return median;
  }
}
