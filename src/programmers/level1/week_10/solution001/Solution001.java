package programmers.level1.week_10.solution001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan" };
        System.out.println(Arrays.toString(sol.solution(record)));
    }

    public String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        Map<String, String> ioStrMap = new HashMap<>();
        ioStrMap.put("Enter", "님이 들어왔습니다.");
        ioStrMap.put("Leave", "님이 나갔습니다.");

        for (int i = 0; i < record.length; i++) {
            String[] r = record[i].split(" ");
            if (r[0].equals("Leave"))
                continue;
            map.put(r[1], r[2]);
        }

        for (int i = 0; i < record.length; i++) {
            String[] r = record[i].split(" ");

            if (r[0].equals("Change"))
                continue;

            list.add(map.get(r[1]) + ioStrMap.get(r[0]));
        }

        String[] answer = new String[list.size()];
        answer = list.toArray(answer);

        return answer;
    }
}
