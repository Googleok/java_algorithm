package programmers.level2.week_18;

import java.util.Stack;

/**
 * 짝지어 제거하기
 * https://programmers.co.kr/learn/courses/30/lessons/12973?language=java
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        System.out.println(sol.solution("baabaa"));
    }

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        return stack.size() == 0 ? 1 : 0;
    }
}
