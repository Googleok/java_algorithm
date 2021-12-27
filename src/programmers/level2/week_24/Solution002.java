package programmers.level2.week_24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [3차] 압축
 * https://programmers.co.kr/learn/courses/30/lessons/17684?language=java
 */
public class Solution002 {
    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        System.out.println(Arrays.toString(solution(msg)));
    }

    static public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        List<String> alpList = new ArrayList<>();
        String alp = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < alp.length(); i++) {
            alpList.add(alp.charAt(i) + "");
        }

        String s = "";
        int idx = 0;
        for (int i = 0; i < msg.length(); i++) {
            s = msg.charAt(i) + "";
            if (alpList.indexOf(s) > -1 && i != msg.length() - 1) {
                idx = i;
                while (msg.length() > idx && alpList.indexOf(msg.substring(i, idx + 1)) > -1) {
                    s = msg.substring(i, ++idx);
                }
                answerList.add(alpList.indexOf(s));
                if (idx < msg.length()) {
                    alpList.add(msg.substring(i, idx + 1));
                }
                i = idx - 1;
            }
        }

        if (idx < msg.length()) {
            answerList.add(alpList.indexOf(msg.charAt(msg.length() - 1) + ""));
        }

        answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
