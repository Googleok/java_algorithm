package programmers.level1.week_11.solution004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution004MY {

    ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Solution004MY sol = new Solution004MY();
        int[] weights = { 50, 82, 75, 120 };
        String[] head2head = { "NLWL", "WNLL", "LWNW", "WWLN" };

        System.out.println(Arrays.toString(sol.solution(weights, head2head)));
    }

    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        ArrayList<String> answerList = new ArrayList<>();
        for (int i = 0; i < weights.length; i++) {
            getInfoString(i, weights, head2head[i]);
        }

        Collections.sort(list, Collections.reverseOrder());

        ArrayList<String> tmpList = new ArrayList<>();
        String[] tmpArr = list.get(0).split("\\|");
        String tmp = tmpArr[0] + "|" + tmpArr[1] + "|" + tmpArr[2];
        tmpList.add(tmpArr[3]);
        for (int i = 1; i < list.size(); i++) {
            String[] tmpArr2 = list.get(i).split("\\|");
            String tmp2 = tmpArr2[0] + "|" + tmpArr2[1] + "|" + tmpArr2[2];

            if (tmp.equals(tmp2)) {
                tmpList.add(tmpArr2[3]);
                continue;
            } else {
                Collections.sort(tmpList);

                for (int j = 0; j < tmpList.size(); j++) {
                    answerList.add(tmpList.get(j));
                }

                tmp = tmp2;
                tmpList.clear();
                tmpList.add(tmpArr2[3]);
            }
        }

        Collections.sort(tmpList);
        for (int j = 0; j < tmpList.size(); j++) {
            answerList.add(tmpList.get(j));
        }

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = Integer.parseInt(answerList.get(i));
        }

        return answer;
    }

    void getInfoString(int idx, int[] weights, String head) {
        String result = "";
        String[] head2 = head.split("");
        int playCnt = 0;
        int winCnt = 0;
        int heavyWinCnt = 0;
        double winRate = 0.0;
        for (int i = 0; i < head2.length; i++) {
            if (head2[i].equals("W")) {
                winCnt++;
                if (weights[idx] < weights[i]) {
                    heavyWinCnt++;
                }
            }
            playCnt++;
        }

        if (playCnt == 0) {
            winRate = 0;
        } else {
            winRate = (double) winCnt / playCnt;
        }

        result = Double.toString(winRate) + "|" + Integer.toString(heavyWinCnt) + "|" + Integer.toString(weights[idx])
                + "|" + Integer.toString(idx + 1);

        list.add(result);
    }

}
