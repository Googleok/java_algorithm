package programmers.level1.week_04.solution001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution001 {

    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        int[] answers = { 1, 3, 2, 4, 2 };
        System.out.println(Arrays.toString(sol.solution(answers)));
    }

    public int[] solution(int[] answers) {
        int[][] user = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
        int[] userCollectCnt = { 0, 0, 0 };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == user[i][j % user[i].length]) {
                    userCollectCnt[i]++;
                }
            }
        }

        int m = Math.max(userCollectCnt[0], Math.max(userCollectCnt[1], userCollectCnt[2]));
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < userCollectCnt.length; i++)
            if (userCollectCnt[i] == m)
                answerList.add(i + 1);

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

}
