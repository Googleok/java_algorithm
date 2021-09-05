package programmers.level1.week_08.solution004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution004 {
    public static void main(String[] args) {
        Solution004 sol = new Solution004();
        int[] arr = { 5, 9, 7, 10 };
        int divisor = 5;
        System.out.println(Arrays.toString(sol.solution(arr, divisor)));
    }

    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                arrayList.add(arr[i]);
            }
        }
        Collections.sort(arrayList);
        if (arrayList.isEmpty())
            arrayList.add(-1);

        answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }
}
