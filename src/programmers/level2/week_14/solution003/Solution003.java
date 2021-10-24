package programmers.level2.week_14.solution003;

import java.util.Arrays;

/**
 * 최솟값 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/12941?language=java
 */
public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        int[] A = { 1, 4, 2 };
        int[] B = { 5, 4, 4 };
        System.out.println(sol.solution(A, B));
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int bIdx = B.length - 1;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[bIdx--];
        }

        return answer;
    }
}
