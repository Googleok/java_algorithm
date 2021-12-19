package programmers.level2.week_22;

/**
 * 땅따먹기 https://programmers.co.kr/learn/courses/30/lessons/12913?language=java
 */
public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
        System.out.println(sol.solution(land));
    }

    int solution(int[][] land) {
        int len = land.length;

        for (int i = 1; i < len; i++) {
            land[i][0] += max(land[i - 1][1], land[i - 1][2], land[i - 1][3]);
            land[i][1] += max(land[i - 1][0], land[i - 1][2], land[i - 1][3]);
            land[i][2] += max(land[i - 1][0], land[i - 1][1], land[i - 1][3]);
            land[i][3] += max(land[i - 1][0], land[i - 1][1], land[i - 1][2]);
        }

        return max(land[len - 1]);
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private int max(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    // static int cnt = 0;
    // static int maxCnt = 0;
    // static int answer = 0;

    // int solution(int[][] land) {

    // int[] t = new int[101];

    // for (int i = 0; i < land.length; i++) {

    // }

    // maxCnt = (int) Math.pow(3, land.length - 1);
    // for (int i = 0; i < land[0].length; i++) {
    // landSum(land, 0, i, land[0][i]);
    // }

    // return answer;
    // }

    // public static void landSum(int[][] land, int curRow, int curCol, int sum) {
    // if (curRow == land.length - 1) {
    // answer = Math.max(answer, sum);
    // cnt++;
    // return;
    // }

    // for (int i = curRow + 1; i < land.length; i++) {
    // for (int j = 0; j < land[i].length; j++) {
    // if (j != curCol) {
    // if (cnt == maxCnt) {
    // cnt = 0;
    // return;
    // }
    // sum += land[i][j];
    // landSum(land, i, j, sum);
    // sum -= land[i][j];
    // }
    // }
    // }
    // }

}
