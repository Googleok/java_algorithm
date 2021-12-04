package programmers.level2.week_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 튜플 https://programmers.co.kr/learn/courses/30/lessons/64065?language=java
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        System.out.println(Arrays.toString(sol.solution(s)));
    }

    public int[] solution(String s) {
        int[] answer = {};
        String s2 = s.substring(1, s.length() - 1);
        String[] s3 = s2.split("},");

        for (int i = 0; i < s3.length; i++) {
            s3[i] = s3[i].replace("{", "");
        }
        s3[s3.length - 1] = s3[s3.length - 1].replace("}", "");

        String[][] s4 = new String[s3.length][];
        for (int i = 0; i < s3.length; i++) {
            String[] temp = s3[i].split(",");
            s4[i] = temp;
        }

        Arrays.sort(s4, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int o1Length = o1.length;
                int o2Length = o2.length;

                return Integer.compare(o1Length, o2Length);
            }
        });

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s4.length; i++) {
            for (int j = 0; j < s4[i].length; j++) {
                if (!list.contains(s4[i][j])) {
                    list.add(s4[i][j]);
                }
            }
        }

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }

        return answer;
    }
}
