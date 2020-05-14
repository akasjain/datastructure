package ds.heap;

import java.util.*;

class MedianOfAStream {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>((i1, i2) -> i1 - i2);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);

    public void insertNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);

        balanceHeap();
    }

    public double findMedian() {

        if(minHeap.size() == maxHeap.size())
            return minHeap.peek()/2 + maxHeap.peek()/ 2;
        else
            return maxHeap.peek();
    }

    private void balanceHeap() {
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
