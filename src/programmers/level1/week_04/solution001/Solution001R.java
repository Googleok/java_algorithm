package programmers.level1.week_04.solution001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution001R {
    int[] a = { 1, 2, 3, 4, 5 };
    int[] b = { 2, 1, 2, 3, 2, 4, 2, 5 };
    int[] c = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
    int aLen = a.length;
    int bLen = b.length;
    int cLen = c.length;
    int check1 = 0;
    int check2 = 0;
    int check3 = 0;

    public static void main(String[] args) {
        Solution001R sol = new Solution001R();
        int[] answers = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(sol.solution(answers)));
    }

    public int[] solution(int[] answers) {
        for (int i = 0; i < answers.length; i++) {
            if (a[i % aLen] == answers[i])
                check1++;
            if (b[i % bLen] == answers[i])
                check2++;
            if (c[i % cLen] == answers[i])
                check3++;
        }

        List<Integer> answerList = new ArrayList<>();
        int m = Collections.max(Arrays.asList(check1, check2, check3));
        if (m == check1)
            answerList.add(1);
        if (m == check2)
            answerList.add(2);
        if (m == check3)
            answerList.add(3);
        answerList.sort(null);

        int[] answerArr = new int[answerList.size()];
        for (int i = 0; i < answerArr.length; i++) {
            answerArr[i] = answerList.get(i);
        }

        return answerArr;
    }
}
