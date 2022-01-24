package programmers.level2.week_27;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 후보키
 * https://programmers.co.kr/learn/courses/30/lessons/42890?language=java
 */
public class Solution003 {
    ArrayList<HashSet<Integer>> candidateKey;

    public static void main(String[] args) {
        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        Solution003 sol = new Solution003();
        System.out.println(sol.solution(relation));
    }

    public int solution(String[][] relation) {
        candidateKey = new ArrayList<>();
        int colSize = relation[0].length;

        for (int i = 1; i <= colSize; ++i) {
            makeKeySet(-1, colSize - 1, 0, i, new HashSet<>(), relation);
        }

        return candidateKey.size();
    }

    private void makeKeySet(int attr, int maxAttr, int idx, int size, HashSet<Integer> keySet, String[][] relation) {
        if (idx == size) {
            for (HashSet<Integer> key : candidateKey) if (keySet.containsAll(key)) return;
            if (isUnique(keySet, relation)) candidateKey.add(keySet);
            return;
        }

        for (int i = attr + 1; i <= maxAttr; ++i) {
            HashSet<Integer> newKeySet = new HashSet<>(keySet);
            newKeySet.add(i);
            makeKeySet(i, maxAttr, idx + 1, size, newKeySet, relation);
        }
    }

    private boolean isUnique(HashSet<Integer> keySet, String[][] relation) {
        HashSet<String> set = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder key = new StringBuilder();

            for (int col : keySet) {
                key.append(row[col]);
            }

            if (set.contains(key.toString())) return false;

            set.add(key.toString());
        }
        return true;
    }
}
