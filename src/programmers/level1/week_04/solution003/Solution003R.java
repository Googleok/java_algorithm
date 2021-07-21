package programmers.level1.week_04.solution003;

// 멋있어보이지만 속도는 Solution003 방식이 훨 빠르다
// 멋있어 보이는 건 다 느리다.
public class Solution003R {
    public static void main(String[] args) {
        Solution003R sol = new Solution003R();
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
                answer += c;
                continue;
            }
            answer += idx % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c);
            idx++;
        }

        return answer;
    }
}
