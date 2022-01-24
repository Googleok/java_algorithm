package programmers.level2.week_27;

import java.util.Arrays;

/**
 * 카카오프렌즈 컬러링북
 * https://programmers.co.kr/learn/courses/30/lessons/1829?language=java
 */
public class Solution001 {
    int area = 0;
    int attrPicture[][];
    boolean check[][];

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        Solution001 sol = new Solution001();
        System.out.println(Arrays.toString(sol.solution(m, n, picture)));
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        attrPicture = picture;
        check = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (picture[row][col] == 0 || check[row][col])
                    continue;
                numberOfArea += 1;
                getArea(row, col);
                if (maxSizeOfOneArea < area)
                    maxSizeOfOneArea = area;
                area = 0;
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public void getArea(int row, int col) {
        check[row][col] = true;
        if (row > 0 && attrPicture[row - 1][col] == attrPicture[row][col] && !check[row - 1][col]) // 상
            getArea(row - 1, col);
        if (row < attrPicture.length - 1 && attrPicture[row + 1][col] == attrPicture[row][col] && !check[row + 1][col]) // 하
            getArea(row + 1, col);
        if (col > 0 && attrPicture[row][col - 1] == attrPicture[row][col] && !check[row][col - 1]) // 좌
            getArea(row, col - 1);
        if (col < attrPicture[row].length - 1 && attrPicture[row][col + 1] == attrPicture[row][col] && !check[row][col + 1]) // 우
            getArea(row, col + 1);
        area += 1;
    }
}
