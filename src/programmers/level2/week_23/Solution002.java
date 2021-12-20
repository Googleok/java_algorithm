package programmers.level2.week_23;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [1차] 캐시
 * https://programmers.co.kr/learn/courses/30/lessons/17680?language=java
 */
public class Solution002 {
    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        int cacheSize = 3;
        String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
        System.out.println(sol.solution(cacheSize, cities));
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
            if (queue.contains(cities[i])) {
                answer++;
                queue.remove(cities[i]);
                queue.add(cities[i]);
            } else {
                answer += 5;
                if (queue.size() == cacheSize) {
                    queue.poll();
                }
                queue.add(cities[i]);
            }
        }

        return answer;
    }
}
