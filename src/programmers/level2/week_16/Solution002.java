package programmers.level2.week_16;

/**
 * 스킬트리 https://programmers.co.kr/learn/courses/30/lessons/49993
 */
public class Solution002 {

    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        String skill = "CBD";
        String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
        System.out.println(sol.solution(skill, skill_trees));
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            boolean res = true;
            int temp = skill_trees[i].indexOf(skill.charAt(0));
            for (int k = 1; k < skill.length(); k++) {
                int idx = skill_trees[i].indexOf(skill.charAt(k));
                if (temp > idx && idx != -1) {
                    res = false;
                    break;
                } else if (idx > -1 && temp == -1) {
                    res = false;
                    break;
                }
                temp = idx;
            }

            if (res) {
                answer++;
            }
        }
        return answer;
    }
}
