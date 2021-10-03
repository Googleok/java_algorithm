package programmers.level1.week_11.solution006;

/**
 * 짝수와 홀수 https://programmers.co.kr/learn/courses/30/lessons/12937
 */
public class Solution006 {
    public static void main(String[] args) {
        Solution006 sol = new Solution006();
        System.out.println(sol.solution(3));
    }

    public String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}
