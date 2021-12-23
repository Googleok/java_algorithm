package leetcode.easy;

import java.util.Arrays;

public class longest_common_prefix {
    public static void main(String[] args) {
        String[] strs = { "ab", "a" };
        System.out.println(longestCommonPrefix(strs));
    }

    static public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs != null && strs.length > 0) {
            Arrays.sort(strs);
            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length - 1].toCharArray();

            for (int i = 0; i < a.length; i++) {
                if (b.length > i && b[i] == a[i]) {
                    result.append(b[i]);
                } else {
                    return result.toString();
                }
            }
        }
        return result.toString();
    }
}
