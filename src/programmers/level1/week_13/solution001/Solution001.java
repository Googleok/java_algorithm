package programmers.level1.week_13.solution001;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 2주차_상호평가
 * https://programmers.co.kr/learn/courses/30/lessons/83201?language=java
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        int[][] scores = { { 50, 90 }, { 50, 87 } };
        System.out.println(sol.solution(scores));
    }

    public String solution(int[][] scores) {
        String answer = "";
        int myScore = 0;
        int scoreSum = 0;
        int div = 0;
        int avg = 0;
        ArrayList<Integer> scoresList = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            div = scores.length;
            myScore = scores[i][i];

            for (int j = 0; j < scores[i].length; j++) {
                scoresList.add(scores[j][i]);
                scoreSum += scores[j][i];
            }

            Collections.sort(scoresList, Collections.reverseOrder());

            if (scoresList.get(0) <= myScore && scoresList.get(1) != myScore) {
                scoreSum -= myScore;
                div--;
            } else if (scoresList.get(scores.length - 1) >= myScore && scoresList.get(scores.length - 2) != myScore) {
                scoreSum -= myScore;
                div--;
            }

            avg = scoreSum / div;
            answer += getRank(avg);

            scoreSum = 0;
            avg = 0;
            scoresList.clear();
        }

        return answer;
    }

    public String getRank(int avg) {
        if (avg >= 90) {
            return "A";
        } else if (90 > avg && avg >= 80) {
            return "B";
        } else if (80 > avg && avg >= 70) {
            return "C";
        } else if (70 > avg && avg >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
