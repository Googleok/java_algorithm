package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class climbing_stairs {
    public static void main(String[] args) {
        climbing_stairs sol = new climbing_stairs();
        System.out.println(sol.climbStairs(44));
    }

    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 2);
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, climbStairs(n - 1, memo) + climbStairs(n - 2, memo));
        return memo.get(n);
    }
}
