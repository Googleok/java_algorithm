package programmers.level2.week_17;

import java.util.Stack;

/**
 * 큰수만들기 https://programmers.co.kr/learn/courses/30/lessons/42883?language=java
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        String number = "4177252841";
        int k = 4;
        System.out.println(sol.solution(number, k));
    }

    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return new String(result);
    }
}
