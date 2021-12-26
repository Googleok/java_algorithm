package leetcode.easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses
 */
public class valid_parentheses {
    public static void main(String[] args) {
        String s = "]";
        System.out.println(isValid(s));
    }

    static public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();
    }

    static public boolean isValid(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                    break;
                default:
                    break;
            }
        }

        return stack.isEmpty();
    }
}
