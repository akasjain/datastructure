package ds.heap;

public interface Heap {

  public void insert(int[] heap, int size, int elem);

  public int delete(int[] heap, int size);

  public void heapify(int[] heap, int size, int index);

  public int[] heapSort(int[] heap);

}
