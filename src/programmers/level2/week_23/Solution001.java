package programmers.level2.week_23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 영어 끝말잇기
 * https://programmers.co.kr/learn/courses/30/lessons/12981?language=java
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        int n = 3;
        String[] words = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };
        System.out.println(Arrays.toString(sol.solution(n, words)));
    }

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> wordList = new ArrayList<>();
        wordList.add(words[0]);
        String tmp = words[0];
        for (int i = 1; i < words.length; i++) {
            if (tmp.endsWith(words[i].charAt(0) + "") == false || wordList.contains(words[i])) {
                answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
                answer[1] = (i / n) + 1;
                break;
            }
            wordList.add(words[i]);
            tmp = words[i];
        }

        return answer;
    }
}
