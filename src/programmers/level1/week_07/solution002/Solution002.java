package programmers.level1.week_07.solution002;

import java.util.Arrays;

public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        int[] d = { 1, 3, 2, 5, 4 };
        int budget = 9;
        System.out.println(sol.solution(d, budget));
    }

    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            if (budget < d[i]) {
                break;
            }
            budget -= d[i];
            answer++;
        }
        return answer;
    }
}
