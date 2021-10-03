package programmers.level1.week_11.solution005;

/**
 * 평균 구하기 https://programmers.co.kr/learn/courses/30/lessons/12944
 */
public class Solution005 {
    public static void main(String[] args) {
        Solution005 sol = new Solution005();
        int[] arr = { 1, 2, 3, 4 };
        System.out.println(sol.solution(arr));
    }

    public double solution(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }
}
