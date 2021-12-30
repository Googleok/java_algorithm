package leetcode.easy;

import java.util.Arrays;

public class plus_one {
    public static void main(String[] args) {
        int[] digits = {9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    static public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 < 10) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }

        if (digits[0] == 0) {
            int[] answer = new int[digits.length + 1];
            answer[0] = 1;
            for (int i = 1; i < answer.length; i++) {
                answer[i] = digits[i - 1];
            }
            return answer;
        }

        return digits;
    }
}
