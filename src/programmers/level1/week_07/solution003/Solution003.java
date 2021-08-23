package programmers.level1.week_07.solution003;

public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        System.out.println(sol.solution(45));
    }

    public int solution(int n) {
        String answer = convert3(n);
        return Integer.parseInt(answer, 3);
    }

    public String convert3(int num) {
        String n = "";
        while (num > 0) {
            n = n + (num % 3);
            num = num / 3;
        }
        return n;
    }
}
