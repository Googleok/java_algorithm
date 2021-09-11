package programmers.level1.week_09.solution002;

import java.util.Arrays;

public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        String[] phone_book = { "12", "123", "1235", "567", "88" };

        System.out.println(sol.solution(phone_book));
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
