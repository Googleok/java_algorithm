package programmers.level1.week_09.solution004;

public class Solution004 {
    public static void main(String[] args) {
        Solution004 sol = new Solution004();
        System.out.println(sol.solution(3));
    }

    public String solution(int n) {
        String answer = "";
        for (int i = 1; i < n + 1; i++) {
            answer += i % 2 != 0 ? "수" : "박";
        }
        return answer;
    }
}
