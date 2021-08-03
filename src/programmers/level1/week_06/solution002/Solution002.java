package programmers.level1.week_06.solution002;

import java.util.Arrays;

public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        int n = 5;
        int[] arr1 = { 9, 20, 28, 18, 11 };
        int[] arr2 = { 30, 1, 21, 17, 28 };
        System.out.println(Arrays.toString(sol.solution(n, arr1, arr2)));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String a = Integer.toBinaryString(arr1[i]);
            String b = Integer.toBinaryString(arr2[i]);
            a = fillZero(n, a);
            b = fillZero(n, b);

            String pass = "";
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == '0' && b.charAt(j) == '0') {
                    pass += " ";
                    continue;
                }
                pass += "#";
            }
            answer[i] = pass;
        }
        return answer;
    }

    public String fillZero(int n, String num) {
        return "0".repeat(n - num.length()) + num;
    }
}
