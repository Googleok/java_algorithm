package programmers.level2.week_21;

import java.util.Arrays;

/**
 * 구명보트 https://programmers.co.kr/learn/courses/30/lessons/42885
 */
public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        int[] people = { 70, 50, 80, 50 };
        int limit = 100;
        System.out.println(sol.solution(people, limit));
    }

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int idx = 0;
        for (int i = people.length - 1; i >= 0; i--) {
            if (idx > i)
                break;
            else if (limit >= (people[i] + people[idx]))
                idx++;
            answer++;
        }

        return answer;
    }
}
