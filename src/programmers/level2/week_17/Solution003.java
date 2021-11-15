package programmers.level2.week_17;

/**
 * 124 나라의 숫자
 * https://programmers.co.kr/learn/courses/30/lessons/12899?language=java
 * 
 */
public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        System.out.println(sol.solution(500000000));
    }

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int share = -1;
        int remain = -1;
        boolean isThree = false;

        while (share != 0) {
            if (n % 3 == 0) {
                n--;
                isThree = true;
            } else {
                isThree = false;
            }

            share = n / 3;
            remain = n % 3;

            if (isThree == true) {
                remain = 4;
            }

            sb.append(remain);
            n /= 3;
        }

        return sb.reverse().toString();
    }
}
