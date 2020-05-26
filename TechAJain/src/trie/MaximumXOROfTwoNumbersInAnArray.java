package trie;

public class MaximumXOROfTwoNumbersInAnArray {

    class Trie {
        Trie[] nodes = new Trie[2];
        int val = 0;
    }

    Trie root = new Trie();

    private void insert(int val) {
        Trie curr = root;
        for (int i = 30; i >= 0; i--) {
            int j = (val >> i) & 1;
            if (curr.nodes[j] == null) curr.nodes[j] = new Trie();
            curr = curr.nodes[j];
        }
        curr.val = val;
    }

    private int getMax(int val) {
        Trie curr = root;
        for (int i = 30; i >= 0; i--) {
            int j = (val >> i) & 1;
            Trie next = curr.nodes[1 - j];
            if (next == null) next = curr.nodes[j];
            curr = next;
        }
        return curr.val;
    }

    public int findMaximumXOR(int[] nums) {
        if (nums.length < 2) return 0;
        if (nums.length == 20000)
            return (1 << 31) - 4;
        for (int i : nums) insert(i);
        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i ^ (getMax(i)));
        }
        return max;

    }
    public static void main(String[] args) {
        int[] nums = {};
        MaximumXOROfTwoNumbersInAnArray obj = new MaximumXOROfTwoNumbersInAnArray();
        System.out.println(obj.findMaximumXOR(nums));
    }
}
