package programmers.level2.week_21;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프린터 https://programmers.co.kr/learn/courses/30/lessons/42587?language=java
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        int[] priorities = { 2, 1, 3, 2 };
        int location = 2;
        System.out.println(sol.solution(priorities, location));
    }

    class Paper {
        int priority;
        int location;

        public Paper() {

        }

        public Paper(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }

        public void setLocation(int location) {
            this.location = location;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }

        public int getLocation() {
            return location;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Paper> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Paper(priorities[i], i));
        }

        boolean isBreak = false;
        while (true) {
            boolean isDeque = true;
            for (Paper item : queue) {
                for (Paper eitherItem : queue) {
                    if (item.getPriority() < eitherItem.getPriority()) {
                        Paper p = queue.poll();
                        queue.offer(p);
                        isDeque = false;
                        break;
                    }
                }
                if (isDeque) {
                    Paper p = queue.poll();
                    answer++;
                    if (p.getLocation() == location) {
                        isBreak = true;
                    }
                }
                break;
            }

            if (isBreak) {
                break;
            }
        }
        return answer;
    }
}
