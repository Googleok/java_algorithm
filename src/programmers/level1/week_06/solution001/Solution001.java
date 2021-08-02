package programmers.level1.week_06.solution001;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
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

        answer = new int[sumSet.size()];
        int idx = 0;
        for (Integer sum : sumSet) {
            answer[idx++] = sum;
        }
        Arrays.sort(answer);

        return answer;
    }
}
