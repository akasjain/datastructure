package ds.heap;

public class MaxHeap implements Heap {

  @Override
  public void insert(int[] heap, int size, int elem) {
    int index = size;  // index at which new element will come
    while(index > 0) {
      int parent = (index - 1) / 2;
      if(elem <= heap[parent]) {
        heap[index] = elem;
        return;
      }
      heap[index] = heap[parent];
      index = parent;
    }
    heap[index] = elem;
  }

  @Override
  public int delete(int[] heap, int size) {
    if(size <= 0)
      return Integer.MIN_VALUE;

    int item = heap[0];
    int last = heap[size-1];
    int index = 0, left = 1, right = 2;

    size = size - 1;

    while(right < size) {

      if(last >= heap[left] && last >= heap[right]) {
        heap[index] = last;
        return last;
      }

      if(heap[right] <= heap[left]) {
        heap[index] = heap[left];
        index = left;
      } else {
        heap[index] = heap[right];
        index = right;
      }

      left = 2 * index + 1;
      right = left + 1;
    }

    if(left == size-1 && last < heap[left]) {
      heap[index] = heap[left];
      index = left;
    }

    heap[index] = last;

    return item;
  }

  @Override
  public void heapify(int[] heap, int size, int index) {

    int val = heap[index];
    int left = 2 * index + 1, right = left + 1;

    while(right < size) {

      if(val >= heap[left] && val >= heap[right])
        return;

      if(heap[right] <= heap[left]) {
        heap[index] = heap[left];
        index = left;
      } else {
        heap[index] = heap[right];
        index = right;
      }

      left = 2 * index + 1;
      right = left + 1;
    }
    if(left == size-1 && val < heap[left]) {
      heap[index] = heap[left];
      index = left;
    }

    heap[index] = val;
}

  @Override
  public int[] heapSort(int[] heap) {
    return new int[0];
  }

  public int getMax(int[] heap, int size) {
    if(size > 0 ) {
      return heap[0];
    }
    return Integer.MIN_VALUE;
  }

  public int extractMax(int[] heap, int size) {
    int max;

    if(size < 1) {
      return Integer.MIN_VALUE;
    }

    max = heap[0];
    heap[0] = heap[size-1];
    heapify(heap, size - 1, 0);

    return max;
  }

  /**
   * Assumes that keyValue is greater than original value
   * @param heap
   * @param size
   * @param keyIndex
   * @param keyValue
   */
  public void increaseKey(int[] heap, int size, int keyIndex, int keyValue) {

    if(keyIndex > size) {
      return;
    }

    int parent = (keyIndex-1) / 2;
    while(keyIndex > 0 && heap[parent] < keyValue) {
      heap[keyIndex] = heap[parent];
      keyIndex = parent;
      parent = (keyIndex-1) / 2;
    }
    heap[keyIndex] = keyValue;
  }
}
