package programmers.level1.week_11.solution003;

import java.util.ArrayList;

/**
 * 최소직사각형 https://programmers.co.kr/learn/courses/30/lessons/86491
 */
public class Solution003 {
    ArrayList<Integer> answers = new ArrayList<>();

    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
        System.out.println(sol.solution(sizes));
    }

    public int solution(int[][] sizes) {
        int answer = 0;
        int w = 0;
        int h = 0;

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] >= sizes[i][1]) {
                w = Math.max(sizes[i][0], w);
                h = Math.max(sizes[i][1], h);
            } else {
                w = Math.max(sizes[i][1], w);
                h = Math.max(sizes[i][0], h);
            }
        }
        answer = w * h;
        return answer;
    }

}
