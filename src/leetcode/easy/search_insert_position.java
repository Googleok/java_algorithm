package leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-insert-position
 */
public class search_insert_position {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }

    static public int searchInsert(int[] nums, int target) {
        int searchedIdx = Arrays.binarySearch(nums, target);
        return searchedIdx < 0 ? Math.abs(searchedIdx) - 1 : searchedIdx;
    }
}
