package programmers.level2.week_26;

import java.util.Arrays;

/**
 * 이진 변환 반복하기
 * https://programmers.co.kr/learn/courses/30/lessons/70129?language=java
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        String s = "110010101001";
        System.out.println(Arrays.toString(sol.solution(s)));
    }

    public int[] solution(String s) {
        int[] answer = new int[2];
        int len = s.length();
        while (s.length() != 1) {
            s = s.replaceAll("0", "");
            answer[0]++;
            answer[1] += len - s.length();
            s = Integer.toBinaryString(s.length());
            len = s.length();
        }

        return answer;
    }
}
