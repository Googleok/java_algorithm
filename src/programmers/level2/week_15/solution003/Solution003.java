package programmers.level2.week_15.solution003;

/**
 * JadenCase 문자열 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/12951#qna
 */
public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        System.out.println(sol.solution("3people  unFollowed   me "));
    }

    public String solution(String s) {
        String answer = "";
        String[] sList = s.trim().split("\\s+");
        String[] spaceList = s.trim().split("\\S+");
        int x = s.length() - 1;
        int lastSpaceLength = 0;

        while (x >= 0 && Character.isWhitespace(s.charAt(x))) {
            lastSpaceLength++;
            x--;
        }

        for (int i = 0; i < sList.length; i++) {
            sList[i] = sList[i].toLowerCase();
            String firstLtr = sList[i].substring(0, 1);
            String restLtrs = sList[i].substring(1);

            firstLtr = firstLtr.toUpperCase();
            sList[i] = firstLtr + restLtrs;
        }

        for (int i = 0; i < sList.length; i++) {
            answer += i == sList.length - 1 ? sList[i] + " ".repeat(lastSpaceLength) : sList[i] + spaceList[i + 1];
        }

        return answer;
    }

    public String solution2(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for (String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }
}
