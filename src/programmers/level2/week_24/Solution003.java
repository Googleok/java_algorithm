package programmers.level2.week_24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [3차] 방금그곡
 * https://programmers.co.kr/learn/courses/30/lessons/17683?language=java
 */
public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(sol.solution(m, musicinfos));
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        List<Music> answerList = new ArrayList<>();
        String[] info;
        int minute1 = 0;
        int minute2 = 0;

        m = replaceStr(m);
        for (int i = 0; i < musicinfos.length; i++) {
            info = musicinfos[i].split(",");
            minute1 = (Integer.parseInt(info[0].substring(0, 2)) * 60) + (Integer.parseInt(info[0].substring(3, 5)));
            minute2 = (Integer.parseInt(info[1].substring(0, 2)) * 60) + (Integer.parseInt(info[1].substring(3, 5)));
            info[3] = replaceStr(info[3]);
            info[3] = info[3].repeat((minute2 - minute1) / info[3].length()) + info[3].substring(0, (minute2 - minute1) % info[3].length());

            if (info[3].contains(m)) {
                answerList.add(new Music(info[2], minute2 - minute1));
            }
        }

        if (answerList.size() == 0) {
            return "(None)";
        }

        Collections.sort(answerList);

        return answerList.get(0).getTitle();
    }

    private String replaceStr(String s) {
        s = s.replaceAll("C#", "H");
        s = s.replaceAll("D#", "I");
        s = s.replaceAll("F#", "J");
        s = s.replaceAll("G#", "K");
        s = s.replaceAll("A#", "L");

        return s;
    }

    class Music implements Comparable<Music> {
        String title;
        int playTime;

        public Music() {

        }

        public Music(String title, int playTime) {
            this.title = title;
            this.playTime = playTime;
        }

        public int getPlayTime() {
            return playTime;
        }

        public void setPlayTime(int playTime) {
            this.playTime = playTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public int compareTo(Music o) {
            return o.getPlayTime() - getPlayTime();
        }
    }
}
