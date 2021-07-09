package programmers.level1.week_02.solution003;

import java.util.Set;
import java.util.HashSet;

public class Solution003R {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        int[] nums = { 3, 3, 3, 2, 2, 4 };
        System.out.println(sol.solution(nums));
    }

    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums)
            set.add(i);
        return (set.size() < nums.length / 2) ? set.size() : nums.length / 2;
    }
}
