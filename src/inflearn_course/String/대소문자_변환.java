package inflearn_course.String;

import java.util.Scanner;

public class 대소문자_변환 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        대소문자_변환 T = new 대소문자_변환();
        String input = sc.next();
        System.out.println(T.solution(input));
    }

    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
//            if (Character.isUpperCase(c)) {
//                sb.append(Character.toLowerCase(c));
//            } else {
//                sb.append(Character.toUpperCase(c));
//            }

//            if (c >= 65 && c <= 90) sb.append(Character.toLowerCase(c));
//            else sb.append(Character.toUpperCase(c));

            if (c >= 65 && c <= 90) sb.append((char) (c + 32));
            else sb.append((char) (c - 32));
        }


        return sb.toString();
    }
}
