package trie;

import java.util.HashMap;
import java.util.Map;

public class MapSumHashMap {
    HashMap<String, Integer> map;
    public MapSumHashMap() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getKey().startsWith(prefix)) {
                sum += entry.getValue();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSumHashMap obj = new MapSumHashMap();
        obj.insert("apple", 3);
        System.out.println(obj.sum("ap"));
        obj.insert("app", 2);
        System.out.println(obj.sum("ap"));
    }
}
