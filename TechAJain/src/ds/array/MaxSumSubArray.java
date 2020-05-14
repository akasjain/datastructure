package ds.array;

public class MaxSumSubArray {
    public static int maxSubArray(int[] nums) {

        int result = nums[0];
        int[] sum =  new int[nums.length];
        sum[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            sum[i] = Math.max(nums[i], sum[i-1] + nums[i]);
            result = Math.max(result, sum[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[] {-2}));
        System.out.println(maxSubArray(new int[] {-2, -1}));
        System.out.println(maxSubArray(new int[] {-1, -2}));
    }
}
