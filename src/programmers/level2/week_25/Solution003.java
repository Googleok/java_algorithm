package programmers.level2.week_25;

import java.util.Arrays;

/**
 * 쿼드압축 후 개수 세기 https://programmers.co.kr/learn/courses/30/lessons/68936?language=java
 */
public class Solution003 {

    static int[] answer = new int[2];

    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        int[][] arr = {{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}};
        System.out.println(Arrays.toString(sol.solution(arr)));
    }

    public int[] solution(int[][] arr) {
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                answer[arr[i][j]]++;
            }
        }

        compression(arr, len, 0, len - 1, 0, len - 1);
        return answer;
    }

    void compression(int[][] arr, int len, int startX, int endX, int startY, int endY) {
        if (len == 1 || startX >= endX || startY >= endY) {
            return;
        }

        int prevNum = arr[startX][startY];
        boolean isBreak = false;

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (prevNum != arr[i][j]) {
                    isBreak = true;
                    break;
                }
            }
            if (isBreak)
                break;
        }

        if (isBreak) {
            len /= 2;
            compression(arr, len, startX, endX - len, startY, endY - len);
            compression(arr, len, startX, endX - len, startY + len, endY);
            compression(arr, len, startX + len, endX, startY, endY - len);
            compression(arr, len, startX + len, endX, startY + len, endY);
        } else {
            answer[prevNum] -= ((endX - startX + 1) * (endY - startY + 1) - 1);
        }
        return;
    }
}
