package programmers.level1.week_04.solution004;

/**
 * 속도는 비슷하지만 줄 수가 더 줄어서 인정
 */
public class Solution004R {
    public static void main(String[] args) {
        Solution004R sol = new Solution004R();
        System.out.println(sol.solution("a B z", 4));
    }

    /**
     * ASCII CODE space 32 A-Z 65-90 a-z 97-122
     */
    public String solution(String s, int n) {
        String result = "";
        n = n % 26;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            } else if (Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }
            result += ch;
        }
        return result;
    }
}
