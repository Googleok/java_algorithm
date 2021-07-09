package programmers.level1.week_02.solution003;

import java.util.*;

public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        int[] nums = { 3, 3, 3, 2, 2, 4 };
        System.out.println(sol.solution(nums));
    }

    public int solution(int[] nums) {
        int answer = 0;
        int pickNum = nums.length / 2;
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        if (set.size() < pickNum) {
            answer = set.size();
        } else {
            answer = pickNum;
        }

        return answer;
    }
}
