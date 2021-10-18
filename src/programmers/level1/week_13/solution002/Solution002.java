package programmers.level1.week_13.solution002;

/**
 * 나머지가 1이 되는 수 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/87389?language=java
 */
public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        System.out.println(sol.solution(12));
    }

    public int solution(int n) {
        int answer = 0;

        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
