package programmers.level1.week_05;

import java.util.Arrays;

public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        int[] arr = { 4, 3, 2, 1 };
        System.out.println(Arrays.toString(sol.solution(arr)));
    }

    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            int[] answer = { -1 };
            return answer;
        }

        int min = arr[0];
        int minIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIdx = i;
            }
        }

        int[] answer = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == minIdx) {
                continue;
            }
            answer[k++] = arr[i];
        }

        return answer;
    }
}
