package programmers.level1.week_10.solution002;

import java.util.Arrays;
import java.util.Collections;

public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        int[] numbers = { 0, 0, 0, 0, 0 };
        System.out.println(sol.solution(numbers));
    }

    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = (numbers[i] + "").repeat(3);
        }
        Arrays.sort(nums, Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            answer += nums[i].substring(0, (nums[i].length() / 3));
        }
        return answer.startsWith("0") == true ? "0" : answer;
    }
}
