package programmers.level1.week_04.solution002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 신박한 방법이라 저장 신박한데 속도는 구리네...
 */
public class Solution002R {
    public static void main(String[] args) {
        Solution002R sol = new Solution002R();
        String[] strings = { "sun", "bed", "car" };
        System.out.println(Arrays.toString(sol.solution(strings, 1)));
    }

    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        return answer;
    }
}
