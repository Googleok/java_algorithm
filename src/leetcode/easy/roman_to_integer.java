package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer
 */
public class roman_to_integer {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCDLXXVI"));
    }

    static public int romanToInt(String s) {
        int answer = 0;
        int len = s.length();
        int curNum = 0;
        int nextNum = 0;
        Map<Character, Integer> numMap = new HashMap<>();
        numMap.put('M', 1000);
        numMap.put('D', 500);
        numMap.put('C', 100);
        numMap.put('L', 50);
        numMap.put('X', 10);
        numMap.put('V', 5);
        numMap.put('I', 1);

        for (int i = 0; i < len - 1; i++) {
            curNum = numMap.get(s.charAt(i));
            nextNum = numMap.get(s.charAt(i + 1));
            if (curNum < nextNum) {
                answer -= curNum;
            } else {
                answer += curNum;
            }
        }

        return answer + numMap.get(s.charAt(len - 1));
    }
}
