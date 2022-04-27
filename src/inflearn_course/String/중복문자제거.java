package inflearn_course.String;

import java.util.Scanner;

public class 중복문자제거 {

    public static void main(String[] args) {
        중복문자제거 T = new 중복문자제거();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }

    private String solution(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
        }
        return answer;
    }

}
