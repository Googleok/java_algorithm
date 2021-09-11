package programmers.level1.week_09.solution001;

import java.util.ArrayList;
import java.util.Collections;

public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        System.out.println(sol.solution("a"));
    }

    public int solution(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        int sLen = s.length();

        if (sLen == 1) {
            return 1;
        }

        for (int i = 1; i <= sLen / 2; i++) {
            int start = 0;
            String newStr = "";
            String temp = "";
            int repeatCnt = 1;
            boolean isRepeat = false;
            for (int j = i; j <= sLen; j += i) {
                String a = s.substring(start, j);
                start += i;

                if (temp.equals(a) == true) {
                    repeatCnt++;
                    isRepeat = true;
                } else {
                    newStr += repeatCnt == 1 ? temp : repeatCnt + temp;
                    temp = a;
                    repeatCnt = 1;
                }
            }
            if (isRepeat == false) {
                list.add(s.length());
            } else {
                newStr += repeatCnt == 1 ? temp : repeatCnt + temp;
                list.add(newStr.length() + (sLen % i));
            }
        }
        Collections.sort(list);
        return list.get(0);
    }
}
