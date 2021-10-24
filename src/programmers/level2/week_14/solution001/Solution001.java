package programmers.level2.week_14.solution001;

import java.util.Arrays;

/**
 * N개의 최소공배수
 * https://programmers.co.kr/learn/courses/30/lessons/12953?language=java
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        int[] arr = { 3, 4, 9, 16 };
        System.out.println(sol.solution(arr));
    }

    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = 1;
        int div = 2;
        int lastArr = arr[arr.length - 1];
        boolean isDiv = true;
        while (div <= lastArr) {
            isDiv = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % div == 0) {
                    isDiv = true;
                    arr[i] /= div;
                }
            }

            if (!isDiv) {
                div++;
            } else {
                answer *= div;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            answer *= arr[i];
        }

        return answer;
    }
}
