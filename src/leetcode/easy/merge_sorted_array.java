package leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array
 */
public class merge_sorted_array {
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int m = 6;
        int[] nums2 = {1, 2, 2};
        int n = 3;
        merge(nums1, m, nums2, n);
    }

    static public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n > 0) {
            int idx = 0;
            for (int i = nums1.length - 1; i > m - 1; i--) {
                if (nums1[i] == 0) nums1[i] = nums2[idx++];
            }

            Arrays.sort(nums1);
        }
        System.out.println(Arrays.toString(nums1));
    }
}
