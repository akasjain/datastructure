package leetcode.challenge.june;

import java.util.*;

/**
 https://leetcode.com/problems/insert-delete-getrandom-o1/

 Design a data structure that supports all following operations in average O(1) time.

 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */
class RandomizedSet {

    /** Initialize your data structure here. */
    Map<Integer, Integer> map;
    List<Integer> list;
    int len;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        len = -1;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            len++;
            map.put(val, len);
            list.add(len, val);
            return true;
        }
        return false;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int idxToDelete = map.get(val);
            map.remove(val);

            if(idxToDelete == len) { // last element to be deleted
                list.remove(len);
            } else {
                int lastNum = list.get(len);
                list.set(idxToDelete, lastNum);
                map.put(lastNum, idxToDelete);
                list.remove(len);
            }
            len--;
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        return list.get(r.nextInt(len+1));
    }
}

class J12_RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }

}