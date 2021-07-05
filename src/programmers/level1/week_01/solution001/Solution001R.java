package programmers.level1.week_01.solution001;

import java.util.*;

class Solution001R {
    public String sol(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String name : participant)
            map.put(name, map.getOrDefault(name, 0) + 1);

        for (String name : completion)
            map.put(name, map.get(name) - 1);

        return getKey(map, 1);
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] participant = { "leo", "kiki", "eden" };
        String[] completion = { "eden", "kiki" };

        Solution001R solution = new Solution001R();
        String answer = solution.sol(participant, completion);
        System.out.println(answer);
    }
}