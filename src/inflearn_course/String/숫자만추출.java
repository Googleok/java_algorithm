package inflearn_course.String;

import java.util.Scanner;

public class 숫자만추출 {
    public static void main(String[] args) {
        숫자만추출 T = new 숫자만추출();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(T.solution(s));
    }

    private int solution(String s) {
        int answer = 0;
        for (char x : s.toCharArray()) {
            if (x >= 48 && x <= 57) answer = answer * 10 + (x - 48);
        }

        return answer;
    }

    private int solution2(String s) {
        StringBuilder answer = new StringBuilder();
        for (char x : s.toCharArray()) {
            if (Character.isDigit(x)) answer.append(x);
        }

        return Integer.parseInt(answer.toString());
    }

}
