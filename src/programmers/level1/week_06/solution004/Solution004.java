package programmers.level1.week_06.solution004;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution004 {
    public static void main(String[] args) {
        Solution004 sol = new Solution004();
        int N = 5;
        int[] stages = { 2, 1, 2, 4, 2, 4, 3, 3 };
        System.out.println(Arrays.toString(sol.solution(N, stages)));
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] attempt = new int[N];
        int[] clear = new int[N];
        double[] failPercent = new double[N];
        ArrayList<Double> fArrayList = new ArrayList<>();

        for (int i = 0; i < stages.length; i++) {
            for (int j = 0; j < stages[i]; j++) {
                if (j < N) {
                    attempt[j]++;
                    if (stages[i] - 1 != j) {
                        clear[j]++;
                    }
                }
            }
        }

        for (int i = 0; i < failPercent.length; i++) {
            Double per = 0.0;
            if (attempt[i] != 0) {
                per = ((attempt[i] - clear[i]) / (double) attempt[i]);
            }
            failPercent[i] = per;
            fArrayList.add(per);
        }
        Arrays.sort(failPercent);

        int x = N - 1;
        for (int i = 0; i < answer.length; i++) {
            int idx = fArrayList.indexOf(failPercent[x--]);
            answer[i] = idx + 1;
            fArrayList.set(idx, (double) -1);
        }

        return answer;
    }
}
