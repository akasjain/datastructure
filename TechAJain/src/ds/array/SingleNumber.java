package ds.array;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int len = nums.length;
        int single = nums[0];
        for(int i=1; i<len; i++) {
            single = single ^ nums[i];
        }

        return single;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {2,2,1}));
    }
}
