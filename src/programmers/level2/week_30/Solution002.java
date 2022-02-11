package programmers.level2.week_30;

import java.util.*;

/**
 * 주차 요금 계산
 * https://programmers.co.kr/learn/courses/30/lessons/92341?language=java
 */
public class Solution002 {

    public static void main(String[] args) {
        Solution002 sol = new Solution002();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {
                "05:34 5961 IN",
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "07:59 5961 OUT",
                "07:59 0148 IN",
                "18:59 0000 IN",
                "19:09 0148 OUT",
                "22:59 5961 IN",
                "23:00 5961 OUT"
        };
        System.out.println(Arrays.toString(sol.solution(fees, records)));
    }

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, Integer> resultMap = new HashMap<>();
        Map<String, Integer> recordsMap = new HashMap<>();

        for (String record : records) {
            String[] r = record.split(" ");
            int minute = timeToMinute(r[0].split(":"));

            if (recordsMap.containsKey(r[1])) {
                int beforeMinute = recordsMap.get(r[1]);
                resultMap.put(r[1], minute - beforeMinute + resultMap.getOrDefault(r[1], 0));
                recordsMap.remove(r[1]);
            } else {
                recordsMap.put(r[1], minute);
            }
        }

        if (!recordsMap.isEmpty()) {
            int lastTime = 23 * 60 + 59;
            for (String rKey : recordsMap.keySet()) {
                resultMap.put(rKey, lastTime - recordsMap.get(rKey) + resultMap.getOrDefault(rKey, 0));
            }
            recordsMap.clear();
        }

        List<String> resultMapKeys = new ArrayList<>(resultMap.keySet());
        Collections.sort(resultMapKeys);

        int idx = 0;
        answer = new int[resultMap.size()];
        for (String key : resultMapKeys) {
            int plusFee = ((int) Math.ceil((resultMap.get(key) - fees[0]) / (double) fees[2]) * fees[3]);
            answer[idx++] = plusFee > 0 ? fees[1] + plusFee : fees[1];
        }

        return answer;
    }

    private int timeToMinute(String[] time) {
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }

}
