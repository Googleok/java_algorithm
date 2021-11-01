package programmers.level2.week_15.solution001;

/**
 * 숫자의 표현 https://programmers.co.kr/learn/courses/30/lessons/12924?language=java
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        System.out.println(sol.solution(15));
    }

    public int solution(int n) {
        int answer = 1;

        for (int i = 1; i <= n / 2; i++) {
            int sum = i;
            for (int j = i + 1; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                } else if (sum > n) {
                    break;
                }
            }
        }

        return answer;
    }
}
