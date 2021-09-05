package programmers.level1.week_08.solution003;

public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        System.out.println(sol.solution(3, 20, 4));
    }

    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i * price;
        }
        answer = sum - money;
        return answer < 0 ? 0 : answer;
    }
}
