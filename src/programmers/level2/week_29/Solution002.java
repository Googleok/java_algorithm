package programmers.level2.week_29;

import java.util.HashMap;
import java.util.Map;

/**
 * 단체사진 찍기 > 다른 풀이 참조함
 * https://programmers.co.kr/learn/courses/30/lessons/1835?language=java
 */
public class Solution002 {
    static String[] d;
    static Map<Character, Integer> map;
    static boolean[] visited;
    static int[] position;
    static int answer;

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        Solution002 sol = new Solution002();
        System.out.println(sol.solution(n, data));
    }

    public int solution(int n, String[] data) {
        d = data;
        map = new HashMap<>();
        visited = new boolean[8];
        position = new int[8];
        answer = 0;
        map.put('A', 0);
        map.put('C', 1);
        map.put('F', 2);
        map.put('J', 3);
        map.put('M', 4);
        map.put('N', 5);
        map.put('R', 6);
        map.put('T', 7);
        dfs(0);
        return answer;
    }

    public void dfs(int idx) {
        if (idx == 8) {
            if (check()) answer++;
        } else {
            for (int i = 0; i < 8; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    position[idx] = i;
                    dfs(idx + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public boolean check() {
        int a, b, res;
        char op;
        for (String s : d) {
            a = position[map.get(s.charAt(0))];
            b = position[map.get(s.charAt(2))];
            op = s.charAt(3);
            res = s.charAt(4) - '0' + 1;

            if (op == '=') {
                if (Math.abs(a - b) != res) return false;
            } else if (op == '>') {
                if (Math.abs(a - b) <= res) return false;
            } else {
                if (Math.abs(a - b) >= res) return false;
            }
        }

        return true;
    }

}
