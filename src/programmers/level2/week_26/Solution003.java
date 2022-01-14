package programmers.level2.week_26;

import java.util.ArrayList;
import java.util.List;

/**
 * [1차] 프렌즈4블록
 * https://programmers.co.kr/learn/courses/30/lessons/17679?language=java
 */
public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(sol.solution(m, n, board));
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] cBoard = new char[board.length][board[0].length()];
        List<Block> deleteBlock = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            cBoard[i] = board[i].toCharArray();
        }

        while (addDeletedBlock(cBoard, deleteBlock)) {
            changeBlockToStar(cBoard, deleteBlock);
            changeLocation(cBoard);
            deleteBlock.clear();
        }

        for (char[] chars : cBoard) {
            for (char aChar : chars) {
                if (aChar == '*') answer++;
            }
        }

        return answer;
    }

    /**
     * 삭제(*) 블록 위아래로 위치 교환
     *
     * @param cBoard
     */
    private void changeLocation(char[][] cBoard) {
        for (int i = 1; i < cBoard.length; i++) {
            for (int j = 0; j < cBoard[i].length; j++) {
                if (cBoard[i][j] == '*') {
                    int x = i;
                    int y = j;
                    while (x > 0) {
                        if (cBoard[x - 1][y] == '*') break;
                        cBoard[x][y] = cBoard[x - 1][y];
                        cBoard[x - 1][y] = '*';
                        x--;
                    }
                }
            }
        }
    }

    /**
     * 삭제 블록 *로 치환
     *
     * @param cBoard
     * @param deleteBlock
     */
    private void changeBlockToStar(char[][] cBoard, List<Block> deleteBlock) {
        for (Block block : deleteBlock)
            cBoard[block.getX()][block.getY()] = '*';
    }

    /**
     * 삭제할 블록 리스트 추가
     *
     * @param cBoard
     * @param deleteBlock
     * @return
     */
    private boolean addDeletedBlock(char[][] cBoard, List<Block> deleteBlock) {
        boolean isDeleted = false;
        for (int i = 0; i < cBoard.length - 1; i++) {
            for (int j = 0; j < cBoard[i].length - 1; j++) {
                if (cBoard[i][j] == '*') continue;
                if (cBoard[i][j] != cBoard[i][j + 1]) continue;
                if (cBoard[i][j] != cBoard[i + 1][j + 1]) continue;
                if (cBoard[i][j] != cBoard[i + 1][j]) continue;
                deleteBlock.add(new Block(i, j));
                deleteBlock.add(new Block(i, j + 1));
                deleteBlock.add(new Block(i + 1, j + 1));
                deleteBlock.add(new Block(i + 1, j));
                isDeleted = true;
            }
        }
        return isDeleted;
    }

    class Block {
        int x;
        int y;

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
