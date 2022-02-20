package programmers.level2.week_31;

import java.util.Stack;

/**
 * 괄호 회전하기
 * https://programmers.co.kr/learn/courses/30/lessons/76502?language=java
 */
public class Solution002 {

    public static void main(String[] args) {
        String s = "[)(]";
        Solution002 sol = new Solution002();
        System.out.println(sol.solution(s));
    }

    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Stack<String> st = new Stack<>();
            s = s.substring(1, s.length()) + s.charAt(0);

            for (int j = 0; j < s.length(); j++) {
                String word = s.substring(j, j + 1);
                if (st.isEmpty()) {
                    st.push(word);
                    continue;
                }

                if (word.equals(")") && st.peek().equals("(")) st.pop();
                else if (word.equals("}") && st.peek().equals("{")) st.pop();
                else if (word.equals("]") && st.peek().equals("[")) st.pop();
                else st.push(word);
            }

            if (st.isEmpty()) answer++;
        }

        return answer;
    }
}
