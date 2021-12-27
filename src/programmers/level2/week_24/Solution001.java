package programmers.level2.week_24;

/**
 * [3차] n진수 게임
 * https://programmers.co.kr/learn/courses/30/lessons/17687?language=java
 */
public class Solution001 {
    public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 1));
    }

    static public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder numStr = new StringBuilder();
        int len = t * m;
        int num;
        String convertNum;
        numStr.append("0");
        for (int i = 1; i <= len; i++) {
            num = i;
            convertNum = "";
            if (numStr.length() > (len)) {
                break;
            }
            while (num > 0) {
                convertNum = getAlph(num % n) + convertNum;
                num /= n;
            }
            // todo 저장 안하고 바로 계산해서 답 추가하기 해도 되는데 귀찮음 > 이렇게 하면 더 빠름
            numStr.append(convertNum);
        }

        for (int i = 0; i < t; i++) {
            answer.append(numStr.charAt((m * i) + p - 1));
        }

        return answer.toString();
    }

    static private String getAlph(int n) {
        String r = "";
        if (n == 10)
            r = "A";
        else if (n == 11)
            r = "B";
        else if (n == 12)
            r = "C";
        else if (n == 13)
            r = "D";
        else if (n == 14)
            r = "E";
        else if (n == 15)
            r = "F";
        else
            r = n + "";
        return r;
    }

}
