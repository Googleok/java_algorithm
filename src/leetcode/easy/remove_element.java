package leetcode.easy;

/**
 * https://leetcode.com/problems/remove-element
 */
public class remove_element {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    static public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[idx++] = nums[i];
        }
        return idx;
    }
}
