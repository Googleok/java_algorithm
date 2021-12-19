package programmers.level2.week_22;

/**
 * 가장 큰 정사각형 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/12905?language=java
 */
public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        int[][] board = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
        System.out.println(sol.solution(board));
    }

    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] dp = new int[n][m];

        // 1열 채우기
        for (int i = 0; i < n; i++) {
            dp[i][0] = board[i][0];
        }

        // 1행 채우기
        for (int i = 0; i < m; i++) {
            dp[0][i] = board[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 1) {
                    // 왼쪽, 위, 왼쪽위 + 1
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer * answer;
    }
}
