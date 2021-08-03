package programmers.level1.week_06.solution002;

import java.util.Arrays;

public class Solution002R {
    public static void main(String[] args) {
        Solution002R sol = new Solution002R();
        int n = 6;
        int[] arr1 = { 46, 33, 33, 22, 31, 50 };
        int[] arr2 = { 27, 56, 19, 14, 14, 10 };
        System.out.println(Arrays.toString(sol.solution(n, arr1, arr2)));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            answer[i] = String.format("%" + n + "s", answer[i]);
            answer[i] = answer[i].replaceAll("1", "#");
            answer[i] = answer[i].replaceAll("0", " ");
        }
        return answer;
    }
}
