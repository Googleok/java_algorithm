package programmers.level1.week_11.solution002;

/**
 * 2016년 https://programmers.co.kr/learn/courses/30/lessons/12901
 */
public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        System.out.println(sol.solution(5, 24));
    }

    public String solution(int a, int b) {
        int days = 0;
        int[] monthDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] week = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };
        for (int i = 0; i < a - 1; i++) {
            days += monthDays[i];
        }
        days += b;
        return week[days % 7];
    }
}
