package programmers.level1.week_08.solution001;

public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        System.out.println(sol.solution("...!@BaT#*..y.abcdefghijklm"));
    }

    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        answer = answer.replaceAll("\\.+", ".");
        if (answer.length() != 0 && answer.substring(0, 1).equals(".") == true)
            answer = answer.substring(1);
        if (answer.length() != 0 && answer.substring(answer.length() - 1).equals(".") == true)
            answer = answer.substring(0, answer.length() - 1);
        if (answer.length() == 0)
            answer = "a";
        else if (answer.length() > 15)
            answer = answer.substring(0, 15);
        if (answer.substring(answer.length() - 1).equals("."))
            answer = answer.substring(0, answer.length() - 1);
        if (answer.length() <= 2) {
            String lastStr = answer.substring(answer.length() - 1);
            answer = answer + lastStr + lastStr + lastStr;
            answer = answer.substring(0, 3);
        }
        return answer;
    }
}
