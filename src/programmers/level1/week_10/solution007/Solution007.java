package programmers.level1.week_10.solution007;

import java.util.Arrays;

public class Solution007 {
    public static void main(String[] args) {
        Solution007 sol = new Solution007();
        System.out.println(Arrays.toString(sol.solution(2, 5)));
    }

    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }

        return answer;
    }

}
