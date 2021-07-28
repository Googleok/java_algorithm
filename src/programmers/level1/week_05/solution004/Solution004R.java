package programmers.level1.week_05.solution004;

public class Solution004R {
    public static void main(String[] args) {
        Solution004R sol = new Solution004R();
        int[] absolutes = { 4, 7, 12 };
        boolean[] signs = { true, false, true };
        System.out.println(sol.solution(absolutes, signs));
    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            answer += absolutes[i] * (signs[i] ? 1 : -1);
        }
        return answer;
    }
}
