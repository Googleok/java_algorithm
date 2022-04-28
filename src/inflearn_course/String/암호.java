package inflearn_course.String;

import java.util.Scanner;

public class 암호 {
    public static void main(String[] args) {
        암호 T = new 암호();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(T.solution(n, str));
    }

    public String solution(int n, String s) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer.append((char) num);
            s = s.substring(7);
        }
        return answer.toString();
    }
}
