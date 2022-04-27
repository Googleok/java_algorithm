package inflearn_course.String;

import java.util.Scanner;

public class 팰린드롬 {
    public static void main(String[] args) {
        팰린드롬 T = new 팰린드롬();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }

    private String solution(String s) {
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        System.out.println(s);
        String tmp = new StringBuilder(s).reverse().toString();
        if (s.equals(tmp)) answer = "YES";
        return answer;
    }

}
