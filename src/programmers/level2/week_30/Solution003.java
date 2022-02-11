package programmers.level2.week_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 양궁대회 참고
 * https://programmers.co.kr/learn/courses/30/lessons/92342?language=java
 */
public class Solution003 {

    static List<int[]> answer = new ArrayList<>();
    static int[] ryan;
    static int[] apeach;
    static int N;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(sol.solution(n, info)));
    }

    public void DFS(int L, int s) {
        if (L == N) {
            int a = 0;
            int r = 0;
            for (int i = 0; i <= 10; i++) {
                if (apeach[i] == 0 && ryan[i] == 0) continue;
                if (apeach[i] < ryan[i]) r += 10 - i;
                else a += 10 - i;
            }
            if (r > a) {
                int diff = r - a;
                if (diff > max) {
                    max = diff;
                    answer.clear();
                    answer.add(ryan.clone());
                } else if (diff == max) answer.add(ryan.clone());
            }
        } else {
            for (int i = s; i < 11; i++) {
                ryan[i]++;
                DFS(L + 1, i);
                ryan[i]--;
            }
        }
    }

    public int[] solution(int n, int[] info) {
        ryan = new int[11];
        N = n;
        apeach = info.clone();
        DFS(0, 0);
        if (answer.isEmpty()) return new int[]{-1};
        answer.sort((o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) return o2[i] - o1[i];
            }
            return 0;
        });
        return answer.get(0);
    }
}
