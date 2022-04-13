package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class longest_substring_without_repeating_character {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 1;
        int sLen = s.length();

        if (sLen <= 1) {
            return sLen;
        }

        int cnt = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sLen; i++) {
            set.add(s.charAt(i));
            cnt++;
            if (set.size() != cnt) {
                if (max < set.size()) max = set.size();
                set.clear();
                cnt = 0;
                i = i - 2;
            }
        }

        if (cnt == set.size() && max < cnt) {
            max = cnt;
        }

        return max;
    }
}
