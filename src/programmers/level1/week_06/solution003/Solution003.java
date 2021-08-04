package programmers.level1.week_06.solution003;

public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
        String hand = "right";

        System.out.println(sol.solution(numbers, hand));
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] matrix = { { 4, 2 }, { 1, 1 }, { 1, 2 }, { 1, 3 }, { 2, 1 }, { 2, 2 }, { 2, 3 }, { 3, 1 }, { 3, 2 },
                { 3, 3 }, { 4, 1 }, { 4, 3 } };
        int leftNum = 10;
        int rightNum = 11;
        for (int number : numbers) {
            int remainder = number % 3;

            if (number == 0) {
                remainder = 2;
            }

            if (remainder == 0) {
                answer += "R";
                rightNum = number;
            } else if (remainder == 1) {
                answer += "L";
                leftNum = number;
            } else {
                int lDistance = Math.abs(matrix[number][0] - matrix[leftNum][0])
                        + Math.abs(matrix[number][1] - matrix[leftNum][1]);
                int rDistance = Math.abs(matrix[number][0] - matrix[rightNum][0])
                        + Math.abs(matrix[number][1] - matrix[rightNum][1]);

                if (lDistance == rDistance) {
                    if (hand.equals("right")) {
                        answer += "R";
                        rightNum = number;
                    } else {
                        answer += "L";
                        leftNum = number;
                    }
                } else if (lDistance > rDistance) {
                    answer += "R";
                    rightNum = number;
                } else {
                    answer += "L";
                    leftNum = number;
                }
            }
        }

        return answer;
    }
}
