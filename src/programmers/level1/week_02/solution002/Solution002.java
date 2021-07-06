package programmers.level1.week_02.solution002;

import java.util.Arrays;

public class Solution002 {

    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        int[] lottos = { 0, 0, 0, 0, 0, 0 };
        int[] win_nums = { 38, 19, 20, 40, 15, 25 };
        System.out.println(Arrays.toString(sol.solution(lottos, win_nums)));
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int matchCnt = 0;
        int zeroCnt = 0;

        Arrays.sort(win_nums);

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCnt++;
                continue;
            }

            if (Arrays.binarySearch(win_nums, lottos[i]) >= 0) {
                matchCnt++;
            }
        }

        // 최고 순위
        answer[0] = getRank(matchCnt + zeroCnt);
        // 최저 순위
        answer[1] = getRank(matchCnt);

        return answer;
    }

    static int getRank(int matchCnt) {
        switch (matchCnt) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }

}
