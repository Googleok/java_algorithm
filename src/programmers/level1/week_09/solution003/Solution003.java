package programmers.level1.week_09.solution003;

public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();

        System.out.println(sol.solution(8, 12));
    }

    public long solution(int w, int h) {
        long answer = (long) w * (long) h;
        long a = w;
        long b = h;

        long gcd = gcd(a, b);

        return answer - (((w / gcd) + (h / gcd) - 1) * gcd);
    }

    // 최대공약수 구하기 (greatest common divisor)
    public long gcd(long a, long b) {
        long r = 0;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}
