package leetcode.easy;

/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class implement_strstr {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issi";
        System.out.println(strStr(haystack, needle));
    }

    static public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
