package programmers.level1.week_06.solution001;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution001R {
    public static void main(String[] args) {
        Solution001R sol = new Solution001R();
        int[] numbers = { 5, 0, 2, 7 };
        System.out.println(Arrays.toString(sol.solution(numbers)));
    }

    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> sumSet = new HashSet<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                sumSet.add(sum);
            }
        }

        Arrays.sort(answer);

        return answer;
    }
}
