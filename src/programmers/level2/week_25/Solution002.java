package programmers.level2.week_25;

/**
 * 점프와 순간이동 https://programmers.co.kr/learn/courses/30/lessons/12980?language=java
 */
public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        System.out.println(sol.solution(5000));
    }

    public int solution(int n) {
        if (n == 1 || n == 2) return n;
        int ans = 1;
        int jump = 1;
        int dis = 1;
        while (dis != n) {
            if (dis * 2 > n) {
                n -= dis;
                dis = jump;
                ans += jump;
            } else {
                dis = dis * 2;
            }
        }
        return ans;
    }
}
