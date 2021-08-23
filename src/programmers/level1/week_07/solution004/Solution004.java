package programmers.level1.week_07.solution004;

public class Solution004 {
    public static void main(String[] args) {
        Solution004 sol = new Solution004();
        System.out.println(sol.solution(24, 27));
    }

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int cnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0)
                    cnt++;
            }
            if (cnt % 2 == 0)
                answer += i;
            else
                answer -= i;
        }
        return answer;
    }
}
