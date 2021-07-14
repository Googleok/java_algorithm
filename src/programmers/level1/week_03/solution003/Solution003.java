package programmers.level1.week_03.solution003;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        int n = 5;
        int[] lost = { 2, 3, 4 };
        int[] reserve = { 3, 4, 5 };
        System.out.println(sol.solution(n, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = arrayToSet(lost);
        Set<Integer> reserveSet = arrayToSet(reserve);

        lostSet.removeAll(reserveSet);
        reserveSet.removeAll(arrayToSet(lost));

        Iterator<Integer> rIt = reserveSet.iterator();
        while (rIt.hasNext()) {
            int rVal = rIt.next();
            if (lostSet.contains(rVal - 1)) {
                lostSet.remove(rVal - 1);
            } else if (lostSet.contains(rVal + 1)) {
                lostSet.remove(rVal + 1);
            }
        }

        return n - lostSet.size();
    }

    public Set<Integer> arrayToSet(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            set.add(i);
        }
        return set;
    }

}
