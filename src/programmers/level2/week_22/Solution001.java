package programmers.level2.week_22;

/**
 * 조이스틱 https://programmers.co.kr/learn/courses/30/lessons/42860?language=java
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        System.out.println(sol.solution("JEROEN"));
    }

    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int min = len - 1;

        int mov;
        char c;
        int nextIdx;
        for (int i = 0; i < len; i++) {
            c = name.charAt(i);
            mov = (c - 'A') < ('Z' - c + 1) ? (c - 'A') : ('Z' - c + 1);
            answer += mov;
            nextIdx = i + 1;

            while (nextIdx < len && name.charAt(nextIdx) == 'A')
                nextIdx++;

            min = Math.min(min, (i * 2) + len - nextIdx);
        }

        answer += min;

        return answer;
    }
}
