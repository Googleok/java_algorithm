package programmers.level1.week_05.solution002;

import java.util.Arrays;

public class Solution002 {

    String[] numFullStrings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    String[] numTwoStrings = { "ze", "on", "tw", "th", "fo", "fi", "si", "se", "ei", "ni" };

    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        System.out.println(sol.solution("one4seveneight"));
    }

    public int solution(String s) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                answer += c;
            } else {
                int index = Arrays.asList(numTwoStrings).indexOf(s.substring(i, i + 2));
                answer += Integer.toString(index);
                i += numFullStrings[index].length() - 1;
            }
        }
        return Integer.parseInt(answer);
    }
}
