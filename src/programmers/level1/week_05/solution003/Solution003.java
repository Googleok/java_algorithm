package programmers.level1.week_05.solution003;

public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        int[] a = { 1, 2, 3, 4 };
        int[] b = { -3, -1, 0, 2 };
        System.out.println(sol.solution(a, b));
    }

    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
