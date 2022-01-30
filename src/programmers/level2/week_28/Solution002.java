package programmers.level2.week_28;


import java.util.*;

/**
 * 순위검색
 * https://programmers.co.kr/learn/courses/30/lessons/72412?language=java
 */
public class Solution002 {
    static Map<String, ArrayList<Integer>> map;

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        Solution002 sol = new Solution002();
        System.out.println(Arrays.toString(sol.solution(info, query)));
    }

    // 조합
    static void comb(String str, int depth, String[] info) {
        if (depth == 4) {
            int score = Integer.parseInt(info[4]);
            if (map.containsKey(str)) {
                map.get(str).add(score);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(score);
                map.put(str, tmp);
            }
            return;
        }
        comb(str + "-", depth + 1, info);
        comb(str + info[depth], depth + 1, info);
    }

    static int binarySearch(String query, int score) {
        if (!map.containsKey(query)) return 0;
        List<Integer> scoreList = map.get(query);
        int start = 0, end = scoreList.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (score > scoreList.get(mid)) start = mid + 1;
            else end = mid - 1;
        }
        return scoreList.size() - start;
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for (String in : info) {
            comb("", 0, in.split(" "));
        }

        // 2. map에 저장된 점수 list 오름차순으로 정렬
        List<String> keys = new ArrayList<>(map.keySet());
        for (String key : keys) {
            List<Integer> scoreList = map.get(key);
            Collections.sort(scoreList);
        }

        int queryIdx = 0;
        for (String q : query) {
            query[queryIdx] = q.replaceAll(" and ", "");
            String[] tmp = query[queryIdx].split(" ");
            answer[queryIdx++] = binarySearch(tmp[0], Integer.parseInt(tmp[1]));
        }

        return answer;
    }


}
