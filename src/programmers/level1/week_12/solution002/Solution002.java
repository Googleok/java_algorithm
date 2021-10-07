package programmers.level1.week_12.solution002;

/**
 * 콜라츠 추측 https://programmers.co.kr/learn/courses/30/lessons/12943#qna
 */
public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        System.out.println(sol.solution(626331));
    }

    public int solution(int num) {
        int answer = 0;
        long n = num;
        while (n != 1) {
            if (answer > 500) {
                answer = -1;
                break;
            }

            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (n * 3) + 1;
            }
            answer++;
        }

        return answer;
    }
}
