package programmers.level1.week_12.solution004;

import java.util.Arrays;

/**
 * 자연수 뒤집어 배열로 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/12932?language=java
 */
public class Solution004 {
    public static void main(String[] args) {
        Solution004 sol = new Solution004();
        System.out.println(Arrays.toString(sol.solution(12345)));
    }

    public int[] solution(long n) {
        String nStr = n + "";
        int[] answer = new int[nStr.length()];
        int idx = 0;
        for (int i = nStr.length() - 1; i >= 0; i--) {
            answer[idx++] = Integer.parseInt(nStr.substring(i, i + 1));
        }
        return answer;
    }

}
