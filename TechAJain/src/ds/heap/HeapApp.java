package ds.heap;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class HeapApp {
  public static void main(String[] args) {
    int[] heap = new int[30];
    int size = 0;
    Heap myHeap = new MaxHeap();
    myHeap.insert(heap, size++, 42);
    myHeap.insert(heap, size++, 30);
    myHeap.insert(heap, size++, 50);
    myHeap.insert(heap, size++, 22);
    myHeap.insert(heap, size++, 60);
    myHeap.insert(heap, size++, 55);
    myHeap.insert(heap, size++, 77);
    myHeap.insert(heap, size++, 55);

    /*Scanner in = new Scanner(new InputStreamReader(System.in));
    System.out.println("Number of elements?");
    int check = in.nextInt();
    heap = new int[check];

    while(check > 0) {
      int num = in.nextInt();
      myHeap.insert(heap, size++, num);
      check--;
    }*/

    System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));

    /*System.out.println(myHeap.delete(heap, size--));
    System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));

    System.out.println(myHeap.delete(heap, size--));
    System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));

    System.out.println(myHeap.delete(heap, size--));
    System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));

    System.out.println(myHeap.delete(heap, size--));
    System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));

    System.out.println(myHeap.delete(heap, size--));
    System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));

    System.out.println(myHeap.delete(heap, size--));
    System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));

    System.out.println(myHeap.delete(heap, size--));
    System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));

    System.out.println(myHeap.delete(heap, size--));
    System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));*/

    heap = new int[] {77,22,60,55,30,42,55,50};
    System.out.println("Distorted " + Arrays.toString(Arrays.copyOf(heap, 8)));

    myHeap.heapify(heap, 8, 1);

    System.out.println("Heapified " + Arrays.toString(Arrays.copyOf(heap, 8)));

    heap = new int[] {70,30,40,15,20,10};
    ((MaxHeap)myHeap).increaseKey(heap, 6, 3, 75);
    System.out.println("After key increase " + Arrays.toString(Arrays.copyOf(heap, 6)));
  }
}
