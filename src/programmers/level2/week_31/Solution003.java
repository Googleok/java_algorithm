package programmers.level2.week_31;

import java.util.ArrayList;
import java.util.List;

/**
 * 모음사전
 * https://programmers.co.kr/learn/courses/30/lessons/84512?language=java
 */
public class Solution003 {

    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        System.out.println(sol.solution("AAAAE"));
    }

    void dfs(String str, int len) {
        if (len > 5) return;
        list.add(str);
        for (int i = 0; i < 5; i++) dfs(str + "AEIOU".charAt(i), len + 1);
    }

    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }
}
