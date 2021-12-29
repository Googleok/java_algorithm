package leetcode.easy;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class maximum_subarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    static public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (max < sum) max = sum;
            if (sum < 0) sum = 0;
        }
        return max;
    }
}
