package programmers.level1.week_03.solution002;

import java.util.Arrays;

public class Solution002 {

    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        int[] array = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
        System.out.println(Arrays.toString(sol.solution(array, commands)));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] newArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(newArray);
            answer[i] = newArray[commands[i][2] - 1];
        }

        return answer;
    }
}
