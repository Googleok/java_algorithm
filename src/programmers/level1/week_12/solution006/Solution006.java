package programmers.level1.week_12.solution006;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * 다트 게임 https://programmers.co.kr/learn/courses/30/lessons/17682?language=java
 */
public class Solution006 {
    public static void main(String[] args) {
        Solution006 sol = new Solution006();
        System.out.println(sol.solution("1D2S#10S"));
    }

    public int solution(String dartResult) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int temp = 0;
        int idx = -1;
        for (int i = 0; i < dartResult.length(); i++) {
            String s = dartResult.charAt(i) + "";
            if (Pattern.matches("[0-9]+", s)) {
                if (i != 0 && Pattern.matches("[0-9]+", dartResult.charAt(i - 1) + "")) {
                    s = temp + s;
                }
                temp = Integer.parseInt(s);
            } else if (Pattern.matches("[a-zA-Z]+", s)) {
                if (s.equals("S")) {
                    temp = (int) Math.pow(temp, 1);
                } else if (s.equals("D")) {
                    temp = (int) Math.pow(temp, 2);
                } else {
                    temp = (int) Math.pow(temp, 3);
                }
                list.add(temp);
                idx++;
            } else {
                if (s.equals("#")) {
                    list.set(idx, list.get(idx) * (-1));
                } else {
                    if (list.size() > 1)
                        list.set(idx - 1, list.get(idx - 1) * 2);
                    list.set(idx, list.get(idx) * 2);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }

        return answer;
    }
}
