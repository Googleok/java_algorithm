package programmers.level1.week_08.solution002;

public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        System.out.println(sol.solution("pPoooyY"));
    }

    boolean solution(String s) {
        boolean answer = true;
        char alpha1 = 'p';
        char alpha2 = 'P';
        char alpha3 = 'y';
        char alpha4 = 'Y';
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (alpha1 == s.charAt(i) || alpha2 == s.charAt(i)) {
                count1++;
            } else if (alpha3 == s.charAt(i) || alpha4 == s.charAt(i)) {
                count2++;
            }
        }
        if (count1 != count2)
            answer = false;
        return answer;
    }
}
