package leetcode.easy;

/**
 * https://leetcode.com/problems/palindrome-number
 */
public class palindrome_number {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(isPalindrome(x));
    }

    static public boolean isPalindrome(int x) {
        String strX = x + "";
        String rStrX = "";

        for (int i = strX.length() - 1; i >= 0; i--) {
            rStrX += strX.charAt(i) + "";
        }

        return strX.equals(rStrX);
    }
}
