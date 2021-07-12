package programmers.level1.week_03.solution001;

import java.util.Stack;

/**
 * 일단 board 2차원 배열의 위치가 굉장히 헷갈림... 입출력 예를 보고 하나하나 손으로 맞춰보고 나서야 위에서부터 아래로 채워지는
 * 2차원 배열이란 걸 알게 됨... 문제엔 그런 설명도 없고 카카오는 참.. 이래저래 꼬을려고 노력함 (처음엔 아래서부터 위로 채워서
 * 풀었었음)
 */
public class Solution001R {

    public static void main(String[] args) {
        Solution001R sol = new Solution001R();
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
            if (stack.isEmpty() == false && stack.peek() == boardValue) {
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
