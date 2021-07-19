package programmers.level1.week_04.solution001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 최소 공배수 구하기
public class Lcm {
    public int getLeastCommonMultiple(int... user) {
        int leastCommonMultiple = 1;
        int shareNum = 2;
        List<Integer> userList = new ArrayList<>(Arrays.asList(convertIntToInteger(user)));
        List<Integer> shareList = new ArrayList<>();

        while (true) {
            boolean isShared = false;
            for (int i = 0; i < user.length; i++) {
                if (userList.get(i) % shareNum == 0) {
                    userList.set(i, userList.get(i) / shareNum);
                    isShared = true;
                }
            }
            if (isShared == true) {
                shareList.add(shareNum);
            }

            if (Collections.frequency(userList, 1) == user.length) {
                break;
            }
            shareNum++;
        }

        for (int j = 0; j < shareList.size(); j++) {
            leastCommonMultiple *= shareList.get(j);
        }

        return leastCommonMultiple;
    }

    public Integer[] convertIntToInteger(int[] arr) {
        Integer[] integers = new Integer[arr.length];
        int i = 0;
        for (int val : arr) {
            integers[i++] = Integer.valueOf(val);
        }
        return integers;
    }
}
