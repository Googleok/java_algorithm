package programmers.level2.week_17;

/**
 * 타겟넘버 https://programmers.co.kr/learn/courses/30/lessons/43165
 */
public class Solution002 {
    int answer = 0;

    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        int[] numbers = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(sol.solution(numbers, target));
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }

    public void dfs(int[] numbers, int depth, int sum, int target) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, depth + 1, sum + numbers[depth], target);
        dfs(numbers, depth + 1, sum - numbers[depth], target);
    }
}
