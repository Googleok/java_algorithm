package programmers.level1.week_11.solution001;

/**
 * 짝수와 홀수 https://programmers.co.kr/learn/courses/30/lessons/12937
 */
public class Solution001 {
    boolean[] check = new boolean[10];

    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        int[] numbers = { 1, 2, 3, 4, 6, 7, 8, 0 };
        System.out.println(sol.solution(numbers));
    }

    public int solution(int[] numbers) {
        int answer = 0;

        for (int i = 0; i < numbers.length; i++) {
            check[numbers[i]] = true;
        }

        for (int i = 0; i < check.length; i++) {
            if (check[i] == false)
                answer += i;
        }

        return answer;
    }
}
