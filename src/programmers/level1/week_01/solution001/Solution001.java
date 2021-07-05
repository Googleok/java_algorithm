package programmers.level1.week_01.solution001;

import java.util.*;

class Solution001 {
    public String sol(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            int nameCount = 1;
            if (map.containsKey(name))
                nameCount += map.get(name);
            map.put(name, nameCount);
        }

        for (String name : completion) {
            int nameCount = map.get(name);
            map.put(name, nameCount - 1);
        }

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

        Solution001 solution = new Solution001();
        String answer = solution.sol(participant, completion);
        System.out.println(answer);
    }
}