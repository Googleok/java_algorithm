package programmers.level2.week_15.solution002;

/**
 * 다음 큰 숫자
 * https://programmers.co.kr/learn/courses/30/lessons/12911?language=java
 */
public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        System.out.println(sol.solution(78));
    }

    public int solution(int n) {
        int answer = 0;
        String nTobinaryStr = Integer.toBinaryString(n);
        int nTobinaryStrLength = nTobinaryStr.length() - nTobinaryStr.replace("1", "").length();

        String str = "";
        int strLength = 0;
        for (int i = n + 1; i < 1000000; i++) {
            str = Integer.toBinaryString(i);
            strLength = str.length() - str.replace("1", "").length();

            if (strLength == nTobinaryStrLength) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
