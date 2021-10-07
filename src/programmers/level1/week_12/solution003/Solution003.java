package programmers.level1.week_12.solution003;

import java.util.Arrays;

/**
 * 최대공약수와 최소공배수
 * https://programmers.co.kr/learn/courses/30/lessons/12940?language=java
 */
public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        System.out.println(Arrays.toString(sol.solution(2, 10)));
    }

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int gcf = 1;
        for (int i = Math.min(n, m); i > 1; i--) {
            if (n % i == 0 && m % i == 0) {
                gcf *= i;
                n /= i;
                m /= i;
            }
        }

        answer[0] = gcf;
        answer[1] = gcf * n * m;

        return answer;
    }
}
