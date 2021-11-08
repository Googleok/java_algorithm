package programmers.level2.week_16;

import java.util.Arrays;

/**
 * H-Index https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        int[] citations = { 3, 0, 6, 1, 5 };
        System.out.println(sol.solution(citations));
    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
