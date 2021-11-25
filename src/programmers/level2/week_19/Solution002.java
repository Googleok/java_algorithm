package programmers.level2.week_19;

import java.util.Arrays;

public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        System.out.println(Arrays.toString(sol.solution(24, 24)));
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int w = 0;
        int h = 0;

        if (yellow == 1) {
            answer[0] = 3;
            answer[1] = 3;
            return answer;
        }

        for (int i = 1; i <= yellow / 2; i++) {
            if (yellow % i != 0) {
                continue;
            }
            w = yellow / i;
            h = i;

            if ((((w + 2) * 2) + (h * 2)) == brown) {
                break;
            }
        }

        answer[0] = w + 2;
        answer[1] = h + 2;

        return answer;
    }
}
