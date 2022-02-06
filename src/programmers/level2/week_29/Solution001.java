package programmers.level2.week_29;

/**
 * 예상 대진표
 * https://programmers.co.kr/learn/courses/30/lessons/12985?language=java
 */
public class Solution001 {

    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        System.out.println(sol.solution(8, 4, 5));
    }

    public int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = (a / 2) + (a % 2);
            b = (b / 2) + (b % 2);
            answer++;
        }

        return answer;
    }
}
