package leetcode.easy;

/**
 * https://leetcode.com/problems/sqrtx/
 */
public class sqrtx {
    public static void main(String[] args) {
        System.out.println(mySqrt(16));
    }

    static public int mySqrt(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }
}
