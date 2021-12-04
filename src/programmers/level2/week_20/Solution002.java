package programmers.level2.week_20;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * [1차] 뉴스 클러스터링 https://programmers.co.kr/learn/courses/30/lessons/17677
 */
public class Solution002 {
    public static void main(String[] args) {
        String str1 = "aa+aa+bb+bb";
        String str2 = "AAAA+BBBB";
        Solution002 sol = new Solution002();
        System.out.println(sol.solution(str1, str2));
    }

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        ArrayList<String> list1 = getCombination(str1);
        ArrayList<String> list2 = getCombination(str2);

        if (list1.size() == 0 && list2.size() == 0) {
            return 65536;
        }

        int totalCnt = list1.size() + list2.size();
        int intersectCnt = 0;

        int idx = 0;
        for (int i = 0; i < list1.size(); i++) {
            idx = list2.indexOf(list1.get(i));
            if (idx > -1) {
                list2.remove(idx);
                intersectCnt++;
            }
        }

        double j = (double) intersectCnt / (totalCnt - intersectCnt);
        return (int) ((double) j * 65536);
    }

    public ArrayList<String> getCombination(String str) {
        ArrayList<String> list = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            boolean isAlp = Pattern.matches("[a-z]", str.charAt(i) + "");
            if (isAlp) {
                if (temp.length() == 2) {
                    list.add(temp);
                    temp = temp.substring(1, 2);
                }
                temp += str.charAt(i);
            } else {
                if (temp.length() == 2) {
                    list.add(temp);
                }
                temp = "";
            }
        }

        if (temp.length() == 2) {
            list.add(temp);
        }

        return list;
    }
}
