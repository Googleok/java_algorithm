package programmers.level2.week_26;

import java.util.Arrays;

/**
 * 삼각 달팽이
 * https://programmers.co.kr/learn/courses/30/lessons/68645?language=java
 */
public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        System.out.println(Arrays.toString(sol.solution(4)));
    }

    public int[] solution(int n) {
        int lastNum = n * (1 + n) / 2;
        int[] answer = new int[lastNum];
        int[][] triangle = new int[n][];

        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
        }

        int num = 1;
        int width = n;
        int height = n;
        int startX = 0;
        int startY = 0;
        while (num <= lastNum) {
            // 하
            for (int i = startX; i < height + startX; i++) {
                triangle[i][startY] = num++;
            }
            // 우
            for (int i = 1 + startY; i < width + startY; i++) {
                triangle[height + startX - 1][i] = num++;
            }
            // 상
            for (int i = height + startX - 2; i >= startX + 1; i--) {
                triangle[i][i - startY] = num++;
            }

            width -= 3;
            height = width;
            startX += 2;
            startY++;
        }

        int idx = 0;
        for (int[] ints : triangle) {
            for (int anInt : ints) {
                answer[idx++] = anInt;
            }
        }

        return answer;
    }
}
