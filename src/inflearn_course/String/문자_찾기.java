package inflearn_course.String;

import java.util.Scanner;

public class 문자_찾기 {

    public static void main(String[] args) {
        문자_찾기 T = new 문자_찾기();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char c = in.next().charAt(0);
        System.out.println(T.solution(str, c));
    }

    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        for (char x : str.toCharArray()) {
            if (x == t) answer++;
        }

        return answer;
    }

}
