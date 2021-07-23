package programmers.level1.week_04.solution004;

public class Solution004 {
    public static void main(String[] args) {
        Solution004 sol = new Solution004();
        System.out.println(sol.solution("a B z", 4));
    }

    /**
     * ASCII CODE space 32 A-Z 65-90 a-z 97-122
     */
    public String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int asciiNum = (int) c;
            if (asciiNum == 32) {
                answer += c;
                continue;
            } else if (asciiNum <= 90 && (asciiNum + n) > 90) {
                asciiNum -= 26;
            } else if (asciiNum >= 97 && (asciiNum + n) > 122) {
                asciiNum -= 26;
            }
            asciiNum += n;
            answer += (char) asciiNum;
        }
        return answer;
    }
}
