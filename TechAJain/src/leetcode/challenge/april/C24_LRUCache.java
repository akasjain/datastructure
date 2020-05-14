package leetcode.challenge.april;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 The cache is initialized with a positive capacity.

 Follow up:
 Could you do both operations in O(1) time complexity?
 */

class LRUCache {

    class Node {
        int key;
        int val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    Deque<Node> deque;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        deque = new LinkedList<>();
        map = new HashMap<>();

    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            deque.remove(node);
            deque.addFirst(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);

        if(map.containsKey(key)) {
            deque.remove(map.get(key));
        } else {
            if(deque.size() == capacity) {
                Node lastNode = deque.removeLast();
                map.remove(lastNode.key);
            }
        }
        map.put(key, node);
        deque.addFirst(node);
    }
}

public class C24_LRUCache {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        obj.put(3,3);
        System.out.println(obj.get(2));
        obj.put(4,4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}
