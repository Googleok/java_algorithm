package programmers.level1.week_06.solution004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Collection.sort class 에 Comparable implements 받아 compareTo 오버라이딩은 놀랍다. 성능도
 * 놀랍다. a > b : 양수를 반환 a == b : 0을 반환 a < b : 음수를 반환
 */
public class Solution004R {
    public static void main(String[] args) {
        Solution004R sol = new Solution004R();
        int N = 5;
        int[] stages = { 2, 1, 2, 4, 2, 4, 3, 3 };
        System.out.println(Arrays.toString(sol.solution(N, stages)));
    }

    public int[] solution(int N, int[] lastStages) {
        int nPlayers = lastStages.length;
        int[] nStagePlayers = new int[N + 2];
        for (int stage : lastStages) {
            nStagePlayers[stage]++;
        }

        int remainingPlayers = nPlayers;
        List<Stage> stages = new ArrayList<>();
        for (int id = 1; id <= N; id++) {
            double failure = (double) nStagePlayers[id] / remainingPlayers;
            remainingPlayers -= nStagePlayers[id];
            Stage s = new Stage(id, failure);
            stages.add(s);
        }

        Collections.sort(stages, Comparator.reverseOrder());

        int[] answer = new int[N];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stages.get(i).id;
        }

        return answer;
    }

    class Stage implements Comparable<Stage> {
        public int id;
        public double failure;

        public Stage(int id, double failure) {
            this.id = id;
            this.failure = failure;
        }

        @Override
        public int compareTo(Stage o) {
            if (this.failure > o.failure) {
                return 1;
            } else if (this.failure < o.failure) {
                return -1;
            }
            return 0;
        }
    }
}
