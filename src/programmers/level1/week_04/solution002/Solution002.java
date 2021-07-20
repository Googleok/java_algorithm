package programmers.level1.week_04.solution002;

import java.util.Arrays;

public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        String[] strings = { "sun", "bed", "car" };
        System.out.println(Arrays.toString(sol.solution(strings, 1)));
    }

    public String[] solution(String[] strings, int n) {
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                String temp = strings[j];
                if (strings[i].charAt(n) > strings[j].charAt(n)) {
                    strings[j] = strings[i];
                    strings[i] = temp;
                } else if (strings[i].charAt(n) == strings[j].charAt(n)) {
                    String[] tempArr = { strings[i], strings[j] };
                    Arrays.sort(tempArr);
                    strings[i] = tempArr[0];
                    strings[j] = tempArr[1];
                }
            }
        }
        return strings;
    }
}
