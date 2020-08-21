package leetcode.challenge.august;

/**
 1286. Iterator for Combination
 https://leetcode.com/problems/iterator-for-combination/

 Design an Iterator class, which has:
 A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
 A function next() that returns the next combination of length combinationLength in lexicographical order.
 A function hasNext() that returns True if and only if there exists a next combination.

 Example:
     CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

     iterator.next(); // returns "ab"
     iterator.hasNext(); // returns true
     iterator.next(); // returns "ac"
     iterator.hasNext(); // returns true
     iterator.next(); // returns "bc"
     iterator.hasNext(); // returns false

 Constraints:
    1 <= combinationLength <= characters.length <= 15
    There will be at most 10^4 function calls per test.
    It's guaranteed that all calls of the function next are valid.
 */
public class AG13_IteratorForCombination {
    static class CombinationIterator {

        private final char[] chars;
        private final int[] ids;

        public CombinationIterator(String characters, int combinationLength) {
            chars = characters.toCharArray();
            ids = new int[combinationLength];
            for(int i = 0; i < combinationLength; i++) {
                ids[i] = i;
            }
            ids[combinationLength - 1]--;
        }

        public String next() {
            update(ids.length - 1);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < ids.length; i++) {
                sb.append(chars[ids[i]]);
            }
            return sb.toString();
        }

        private void update(int idx) {
            if (idx < 0 || idx >= ids.length) return;
            ids[idx]++;
            if (ids[idx] >= chars.length - (ids.length - 1 - idx)) {
                update(idx - 1);
                ids[idx] = ids[idx - 1] + 1;
            }
        }

        public boolean hasNext() {
            return ids[0] != chars.length - ids.length;
        }
    }

    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("abc", 2);

        System.out.println(iterator.next());    // returns "ab"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next());    // returns "ac"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next());    // returns "bc"
        System.out.println(iterator.hasNext()); // returns false
    }
}
