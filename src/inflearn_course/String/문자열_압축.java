package inflearn_course.String;

import java.util.Scanner;

public class 문자열_압축 {
    public static void main(String[] args) {
        문자열_압축 T = new 문자열_압축();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        s = s + " ";
        int cnt = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            } else {
                answer.append(s.charAt(i));
                if (cnt > 1) answer.append(cnt);
                cnt = 1;
            }
        }
        return answer.toString();
    }

}
