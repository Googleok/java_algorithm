package programmers.level1.week_10.solution006;

public class Solution006 {
    public static void main(String[] args) {
        Solution006 sol = new Solution006();
        System.out.println(sol.solution("01033334444"));
    }

    public String solution(String phone_number) {
        String answer = "";
        for (int i = 0; i < phone_number.length() - 4; i++) {
            answer += "*";
        }
        return answer + phone_number.substring(phone_number.length() - 4, phone_number.length());
    }
}
