package programmers.level1.week_04.solution003;

public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        String s = "try hello world";
        System.out.println(sol.solution(s));
    }

    public String solution(String s) {
        String answer = "";
        char c = 'a';

        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ' ') {
                idx = 0;
                answer = answer.concat(Character.toString(c));
                continue;
            }
            if (idx % 2 == 0) {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }
            answer = answer.concat(Character.toString(c));
            idx++;
        }

        return answer;
    }
}
