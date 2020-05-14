package leetcode.challenge.april;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**

 */
public class C28_FirstUniqueNumber {
    class Node {
        int value;
        int count;

        public Node(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    Deque<Node> deque;
    Map<Integer, Node> map;

    public C28_FirstUniqueNumber(int[] nums) {
        deque = new LinkedList<>();
        map = new HashMap<>();

        for(int num: nums) {

            if(map.containsKey(num)) {
                Node node = map.get(num);
                if(node.count == 1)
                    deque.remove(node);
                node.count++;
            } else {
                Node node = new Node(num, 1);
                map.put(num, node);
                deque.offerLast(node);
            }
        }
    }

    public int showFirstUnique() {
        if(!deque.isEmpty()) {
            return deque.getFirst().value;
        }
        return -1;
    }

    public void add(int value) {
        if(map.containsKey(value)) {
            Node node = map.get(value);
            if(node.count == 1)
                deque.remove(node);
            node.count++;
        } else {
            Node node = new Node(value, 1);
            map.put(value, node);
            deque.offerLast(node);
        }
    }

    public static void main(String[] args) {
        C28_FirstUniqueNumber firstUnique = new C28_FirstUniqueNumber(new int[]{7,7,7,7,7,7});
        System.out.println(firstUnique.showFirstUnique()); // return -1
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
        firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        System.out.println(firstUnique.showFirstUnique()); // return 17
    }
}
