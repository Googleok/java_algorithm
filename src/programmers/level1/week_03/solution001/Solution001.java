package programmers.level1.week_03.solution001;

import java.util.Stack;

public class Solution001 {

    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
                { 3, 5, 1, 3, 1 } };
        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

        System.out.println(sol.solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            int boardValue = 0;
            for (int i = 0; i < board.length; i++) {
                int tmp = board[i][move - 1];
                if (tmp != 0) {
                    boardValue = tmp;
                    board[i][move - 1] = 0;
                    break;
                }
            }

            if (stack.empty() == false && stack.peek() == boardValue) {
                stack.pop();
                answer = answer + 2;
                continue;
            }

            if (boardValue != 0) {
                stack.push(boardValue);
            }
        }

        return answer;
    }
}
