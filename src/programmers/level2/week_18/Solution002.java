package programmers.level2.week_18;

/**
 * 괄호 변환 https://programmers.co.kr/learn/courses/30/lessons/60058?language=java
 */
public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        System.out.println(sol.solution("()))((()"));
    }

    public String solution(String p) {
        StringBuilder sb = new StringBuilder();
        if (p.length() == 0) {
            return sb.toString();
        }

        String u = null;
        String v = null;
        int cnt = p.charAt(0) == '(' ? 1 : -1;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt == 0) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }

        if (isRight(u)) {
            sb.append(u);
            sb.append(solution(v));
        } else {
            sb.append("(" + solution(v) + ")");
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(')
                    sb.append(')');
                if (u.charAt(i) == ')')
                    sb.append('(');
            }
        }

        return sb.toString();
    }

    public boolean isRight(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt < 0) {
                return false;
            }
        }
        return true;
    }
}
