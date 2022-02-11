package programmers.level2.week_30;

/**
 * k진수에서 소수 개수 구하기
 * https://programmers.co.kr/learn/courses/30/lessons/92335?language=java
 */
public class Solution001 {

    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        System.out.println(sol.solution(437674, 3));
    }

    public int solution(int n, int k) {
        int answer = 0;
        String radixStr = Integer.toString(n, k);
        String[] nums = radixStr.split("0");

        for (String num : nums) {
            if (num.equals("")) continue;
            if (isPrime(Long.parseLong(num))) answer++;
        }

        return answer;
    }

    private boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
