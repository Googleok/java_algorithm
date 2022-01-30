package programmers.level2.week_28;

import java.util.ArrayList;
import java.util.List;

/**
 * 수식 최대화
 * https://programmers.co.kr/learn/courses/30/lessons/67257#qna
 */
public class Solution003 {
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        Solution003 sol = new Solution003();
        System.out.println(sol.solution(expression));
    }

    public long solution(String expression) {
        String[] longArr = expression.split("[^0-9]");
        List<Long> longList = new ArrayList<>();
        for (String l : longArr)
            longList.add(Long.parseLong(l));

        String[] opsArr = expression.split("[0-9]+");
        List<String> opsList = new ArrayList<>();
        for (int i = 1; i < opsArr.length; i++) {
            opsList.add(opsArr[i]);
        }
        List<Long> longTemp;
        List<String> opsTemp;

        long max = 0;

        longTemp = new ArrayList<>(longList);
        opsTemp = new ArrayList<>(opsList);
        calcProc(longTemp, opsTemp, new String[]{"+", "-", "*"});
        max = Math.max(max, Math.abs(longTemp.get(0)));

        longTemp = new ArrayList<>(longList);
        opsTemp = new ArrayList<>(opsList);
        calcProc(longTemp, opsTemp, new String[]{"+", "*", "-"});
        max = Math.max(max, Math.abs(longTemp.get(0)));

        longTemp = new ArrayList<>(longList);
        opsTemp = new ArrayList<>(opsList);
        calcProc(longTemp, opsTemp, new String[]{"-", "+", "*"});
        max = Math.max(max, Math.abs(longTemp.get(0)));

        longTemp = new ArrayList<>(longList);
        opsTemp = new ArrayList<>(opsList);
        calcProc(longTemp, opsTemp, new String[]{"-", "*", "+"});
        max = Math.max(max, Math.abs(longTemp.get(0)));

        longTemp = new ArrayList<>(longList);
        opsTemp = new ArrayList<>(opsList);
        calcProc(longTemp, opsTemp, new String[]{"*", "-", "+"});
        max = Math.max(max, Math.abs(longTemp.get(0)));

        longTemp = new ArrayList<>(longList);
        opsTemp = new ArrayList<>(opsList);
        calcProc(longTemp, opsTemp, new String[]{"*", "+", "-"});
        max = Math.max(max, Math.abs(longTemp.get(0)));

        return max;
    }

    public void calcProc(List<Long> longLi, List<String> opsLi, String[] ops) {
        calc(longLi, opsLi, ops[0]);
        calc(longLi, opsLi, ops[1]);
        calc(longLi, opsLi, ops[2]);
    }

    public void calc(List<Long> longLi, List<String> opsLi, String ops) {
        int i = 0;
        int length = opsLi.size();

        while (i < length) {
            if (ops.equals(opsLi.get(i))) {
                switch (ops) {
                    case "+":
                        longLi.set(i, longLi.get(i) + longLi.get(i + 1));
                        break;
                    case "-":
                        longLi.set(i, longLi.get(i) - longLi.get(i + 1));
                        break;
                    case "*":
                        longLi.set(i, longLi.get(i) * longLi.get(i + 1));
                        break;
                }
                longLi.remove(i + 1);
                opsLi.remove(i);
                i--;
                length--;
            }
            i++;
        }
    }

}
