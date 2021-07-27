package programmers.level1.week_05.solution002;

// replaceAll 이라는 함수가 있었다니...삽질했구나...창피하다
public class Solution002R {

    String[] numStrings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static void main(String[] args) {
        Solution002R sol = new Solution002R();
        System.out.println(sol.solution("one4seveneight"));
    }

    public int solution(String s) {
        for (int i = 0; i < numStrings.length; i++) {
            s = s.replaceAll(numStrings[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
