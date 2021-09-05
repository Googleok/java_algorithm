package programmers.test;

import java.util.Arrays;

public class Test03 {
    public static void main(String[] args) {
        Test03 sol = new Test03();
        int[][] needs = { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        int r = 2;

        System.out.println(sol.solution(needs, r));
    }

    public int solution(int[][] needs, int r) {
        int answer = 0;
        int[] parts = new int[needs[0].length];

        for (int i = 0; i < parts.length; i++) {
            for (int j = 0; j < needs.length; j++) {
                parts[i] += needs[j][i];
            }
        }
        int[] copy = Arrays.copyOfRange(parts, 0, parts.length);
        Arrays.sort(copy);
        int[] max = Arrays.copyOfRange(copy, parts.length - r, parts.length);

        int[] maxIdx = {};

        for (int i = 0; i < r; i++) {
            maxIdx[i] = Arrays.binarySearch(parts, max[i]);
        }

        // for (int i = 0; i < needs.length; i++) {
        // boolean access = true;
        // for (int j = 0; j < needs[i].length; j++) {
        // if (needs[i][j] == 1) {
        // if (j != maxIndex1 && j != maxIndex2) {
        // access = false;
        // }
        // }
        // }
        // answer += access == true ? 1 : 0;
        // }

        return answer;
    }
}
