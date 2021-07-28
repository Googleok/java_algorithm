package programmers.level1.week_05.solution004;

public class Solution004 {
    public static void main(String[] args) {
        Solution004 sol = new Solution004();
        int[] absolutes = { 4, 7, 12 };
        boolean[] signs = { true, false, true };
        System.out.println(sol.solution(absolutes, signs));
    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            answer += signs[i] == true ? absolutes[i] : (absolutes[i] * -1);
        }
        return answer;
    }
}
