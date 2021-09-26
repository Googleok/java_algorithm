package programmers.level1.week_10.solution004;

public class Solution004 {
    public static void main(String[] args) {
        Solution004 sol = new Solution004();
        String[] seoul = { "Jane", "Kim" };
        System.out.println(sol.solution(seoul));
    }

    public String solution(String[] seoul) {
        String answer = "";
        String kim = "Kim";
        for (int i = 0; i < seoul.length; i++) {
            if (kim.equals(seoul[i])) {
                answer += i;
            }
        }
        return "김서방은 " + answer + "에 있다";
    }
}
