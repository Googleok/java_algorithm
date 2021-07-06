package programmers.level1.week_02.solution001;

/**
 * 이 코드는 효율성도 Shit
 */
public class Solution001 {
    static int primeNumCnt = 0;

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(solution(nums));
    }

    static int solution(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        combination(nums, visited, 0, nums.length, 3);
        return primeNumCnt;
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int sum = visitedNumSum(arr, visited, n);
            if (isPrime(sum)) {
                primeNumCnt++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static int visitedNumSum(int[] arr, boolean[] visited, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += arr[i];
            }
        }
        return sum;
    }

    static boolean isPrime(int num) {
        boolean isFrime = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                isFrime = false;
            }
        }
        return isFrime;
    }
}