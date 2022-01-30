package programmers.level2.week_28;

import java.util.Arrays;

/**
 * 거리두기 확인하기
 * https://programmers.co.kr/learn/courses/30/lessons/81302?language=java
 */
public class Solution001 {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}, {"OOPOO", "OPOOO", "OOOOO", "OOOOO", "OOOOO"}};
        Solution001 sol = new Solution001();
        System.out.println(Arrays.toString(sol.solution(places)));
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int cnt = 0;
        boolean isPass;
        for (int i = 0; i < places.length; i++) {
            isPass = true;
            for (int j = 0; j < places[i].length; j++) {
                for (int k = 0; k < places[i][j].length(); k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        // 상
                        if (j > 0 && places[i][j - 1].charAt(k) == 'P') {
                            isPass = false;
                            break;
                        }
                        // 하
                        if (j < 4 && places[i][j + 1].charAt(k) == 'P') {
                            isPass = false;
                            break;
                        }
                        // 좌
                        if (k > 0 && places[i][j].charAt(k - 1) == 'P') {
                            isPass = false;
                            break;
                        }
                        // 우
                        if (k < 4 && places[i][j].charAt(k + 1) == 'P') {
                            isPass = false;
                            break;
                        }
                        // 상 두칸
                        if (j > 1 && places[i][j - 2].charAt(k) == 'P' && places[i][j - 1].charAt(k) != 'X') {
                            isPass = false;
                            break;
                        }
                        // 하 두칸
                        if (j < 3 && places[i][j + 2].charAt(k) == 'P' && places[i][j + 1].charAt(k) != 'X') {
                            isPass = false;
                            break;
                        }
                        // 좌 두칸
                        if (k > 1 && places[i][j].charAt(k - 2) == 'P' && places[i][j].charAt(k - 1) != 'X') {
                            isPass = false;
                            break;
                        }
                        // 우 두칸
                        if (k < 3 && places[i][j].charAt(k + 2) == 'P' && places[i][j].charAt(k + 1) != 'X') {
                            isPass = false;
                            break;
                        }
                        // 왼쪽 위
                        if (j > 0 && k > 0 && places[i][j - 1].charAt(k - 1) == 'P' && (places[i][j].charAt(k - 1) != 'X' || places[i][j - 1].charAt(k) != 'X')) {
                            isPass = false;
                            break;
                        }
                        // 오른쪽 위
                        if (j > 0 && k < 4 && places[i][j - 1].charAt(k + 1) == 'P' && (places[i][j].charAt(k + 1) != 'X' || places[i][j - 1].charAt(k) != 'X')) {
                            isPass = false;
                            break;
                        }
                        // 왼쪽 아래
                        if (j < 4 && k > 0 && places[i][j + 1].charAt(k - 1) == 'P' && (places[i][j].charAt(k - 1) != 'X' || places[i][j + 1].charAt(k) != 'X')) {
                            isPass = false;
                            break;
                        }
                        // 오른쪽 아래
                        if (j < 4 && k < 4 && places[i][j + 1].charAt(k + 1) == 'P' && (places[i][j].charAt(k + 1) != 'X' || places[i][j + 1].charAt(k) != 'X')) {
                            isPass = false;
                            break;
                        }
                    }
                }

                if (!isPass) {
                    break;
                }
            }

            answer[i] = isPass ? 1 : 0;
        }

        return answer;
    }


}
