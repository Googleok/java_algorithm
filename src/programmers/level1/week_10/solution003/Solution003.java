package programmers.level1.week_10.solution003;

import java.util.HashSet;

public class Solution003 {

    public int answer = 0;
    public boolean[] chk;
    public String[] numStrings;
    HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        System.out.println(sol.solution("1234"));
    }

    public int solution(String numbers) {
        chk = new boolean[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            combination(numbers, "", i + 1);
        }

        for (Integer num : set) {
            isPrime(num);
        }

        return answer;
    }

    void combination(String numbers, String tmp, int numLength) {
        if (tmp.length() == numLength && !set.contains(Integer.parseInt(tmp))) {
            set.add(Integer.parseInt(tmp));
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!chk[i]) {
                chk[i] = true;
                tmp += numbers.substring(i, i + 1);
                combination(numbers, tmp, numLength);
                chk[i] = false;
                tmp = tmp.substring(0, tmp.length() - 1);
            }
        }
    }

    void isPrime(Integer num) {
        if (num == 0 || num == 1)
            return;

        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return;
        }

        answer++;
    }
}