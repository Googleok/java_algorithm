package programmers.level1.week_02.solution001;

/**
 * 시간을 너무 많이 사용함... 그냥 간단하게 삼중 for문 돌리면 될 걸 복잡하게 생각..
 */
public class Solution001R {
    static int answer = 0;

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int result = solution(nums);
        System.out.println(result);
    }

    static int solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    checkPrime(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        return answer;
    }

    static void checkPrime(int sum) {
        boolean isFrime = true;
        for (int i = 2; i < sum; i++) {
            if (sum % i == 0) {
                isFrime = false;
                return;
            }
        }

        if (isFrime == true) {
            answer++;
        }
    }
}