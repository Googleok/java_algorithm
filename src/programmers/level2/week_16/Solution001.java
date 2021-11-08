package programmers.level2.week_16;

/**
 * 올바른 괄호 https://programmers.co.kr/learn/courses/30/lessons/12909
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        System.out.println(sol.solution("()()"));
    }

    boolean solution(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }
}
