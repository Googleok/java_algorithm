package programmers.level1.week_12.solution007;

/**
 * 3진법 뒤집기
 * https://programmers.co.kr/learn/courses/30/lessons/68935?language=java
 */
public class Solution007 {
    public static void main(String[] args) {
        Solution007 sol = new Solution007();
        System.out.println(sol.solution(45));
    }

    public int solution(int n) {
        String radix3 = changeRadix(n, 3);
        String radix3Reverse = new StringBuffer(radix3).reverse().toString();
        return Integer.parseInt((radix3Reverse), 3);
    }

    public String changeRadix(int n, int r) {
        String ans = "";

        while (n > 0) {
            ans = (n % r) + ans;
            n /= r;
        }

        return ans;
    }
}
