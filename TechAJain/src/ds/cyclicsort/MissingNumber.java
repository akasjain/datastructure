package ds.cyclicsort;

class MissingNumber {

    public static int findMissingNumber(int[] nums) {

        int i = 0;
        int len = nums.length;
        while(i < len) {
            int j = nums[i];
            if(nums[i] != len && nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
        int ans = 0;
        for (int j = 0; j < len; j++) {
            if (nums[j] != j) {
                ans = j;
                break;
            }

        }
        return ans;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
