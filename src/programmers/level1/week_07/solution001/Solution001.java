package programmers.level1.week_07.solution001;

import java.util.Arrays;
import java.util.Collections;

public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        long n = 118372;
        System.out.println(sol.solution(n));
    }

    public long solution(long n) {
        String answer = "";
        String nString = Long.toString(n);
        Integer[] arr = new Integer[nString.length()];

        for (int i = 0; i < nString.length(); i++) {
            arr[i] = Integer.parseInt(nString.substring(i, i + 1));
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            answer += Integer.toString(arr[i]);
        }

        return Long.parseLong(answer);
    }

}
