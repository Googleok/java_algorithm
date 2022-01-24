package programmers.level2.week_27;

import java.util.Arrays;

/**
 * 행렬 테두리 회전하기
 * https://programmers.co.kr/learn/courses/30/lessons/77485?language=java
 */
public class Solution002 {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        Solution002 sol = new Solution002();
        System.out.println(Arrays.toString(sol.solution(rows, columns, queries)));
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] square = createSquare(rows, columns);

        int idx = 0;
        for (int[] query : queries) {
            int min = 10000;
            int startX = query[0] - 1;
            int endX = query[2] - 1;
            int startY = query[1] - 1;
            int endY = query[3] - 1;
            int cur = square[startX][startY];
            int next = 0;

            // 동
            for (int i = startY; i < endY; i++) {
                if (min > cur) min = cur;
                next = square[startX][i + 1];
                square[startX][i + 1] = cur;
                cur = next;
            }

            // 남
            for (int i = startX; i < endX; i++) {
                if (min > cur) min = cur;
                next = square[i + 1][endY];
                square[i + 1][endY] = cur;
                cur = next;
            }

            // 서
            for (int i = endY; i > startY; i--) {
                if (min > cur) min = cur;
                next = square[endX][i - 1];
                square[endX][i - 1] = cur;
                cur = next;
            }

            // 북
            for (int i = endX; i > startX; i--) {
                if (min > cur) min = cur;
                next = square[i - 1][startY];
                square[i - 1][startY] = cur;
                cur = next;
            }

            answer[idx++] = min;
        }

        return answer;
    }

    private int[][] createSquare(int rows, int columns) {
        int[][] square = new int[rows][columns];
        int val = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                square[i][j] = val++;
            }
        }

        return square;
    }
}
