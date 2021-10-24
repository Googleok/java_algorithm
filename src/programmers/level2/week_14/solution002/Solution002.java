package programmers.level2.week_14.solution002;

import java.util.Arrays;

/**
 * 행렬의 곱셈 https://programmers.co.kr/learn/courses/30/lessons/12949?language=java
 */
public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        int[][] arr1 = { { 1, 2 }, { 3, 4 } };
        int[][] arr2 = { { 3, 3 }, { 2, 2 } };
        System.out.println(Arrays.toString(sol.solution(arr1, arr2)));
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
