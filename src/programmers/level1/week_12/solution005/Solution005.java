package programmers.level1.week_12.solution005;

/**
 * 소수 찾기 https://programmers.co.kr/learn/courses/30/lessons/12921?language=java
 */
public class Solution005 {
    int primeCnt = 0;

    public static void main(String[] args) {
        Solution005 sol = new Solution005();
        System.out.println(sol.solution(10));
    }

    public int solution(int n) {
        for (int i = 2; i <= n; i++) {
            isPrime(i);
        }

        return primeCnt;
    }

    void isPrime(int n) {
        if (n == 2 || n == 3) {
            primeCnt++;
            return;
        }

        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return;
            }
        }
        primeCnt++;
        return;
    }
}
