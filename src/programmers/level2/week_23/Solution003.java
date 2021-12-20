package programmers.level2.week_23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * [3차] 파일명 정렬
 * https://programmers.co.kr/learn/courses/30/lessons/17686?language=java
 */
public class Solution003 {
    public static void main(String[] args) {
        Solution003 sol = new Solution003();
        String[] files = { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
        System.out.println(Arrays.toString(sol.solution(files)));
    }

    class FileObject implements Comparable<FileObject> {
        String head;
        int number;
        String tail;
        int origIdx;
        String origTxt;

        public FileObject() {

        }

        public FileObject(String head, int number, String tail, int origIdX, String origTxt) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.origIdx = origIdX;
            this.origTxt = origTxt;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getTail() {
            return tail;
        }

        public void setTail(String tail) {
            this.tail = tail;
        }

        public int getOrigIdx() {
            return origIdx;
        }

        public void setOrigIdx(int origIdx) {
            this.origIdx = origIdx;
        }

        public String getOrigTxt() {
            return origTxt;
        }

        public void setOrigTxt(String origTxt) {
            this.origTxt = origTxt;
        }

        @Override
        public int compareTo(FileObject o) {
            int comH = o.getHead().compareTo(getHead());
            boolean comN = o.getNumber() < getNumber();
            boolean comO = o.getOrigIdx() < getOrigIdx();
            if (comH < 0) {
                return 1;
            } else {
                if (comH == 0) {
                    if (comN == true) {
                        return 1;
                    } else {
                        if (comH == 0 && o.getNumber() == getNumber() && comO == true) {
                            return 1;
                        }
                    }
                }
            }
            return -1;
        }
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<FileObject> list = new ArrayList<>();

        for (int k = 0; k < files.length; k++) {
            String f = files[k].toLowerCase();
            String head = "";
            int number = 0;
            String tail = "";
            for (int i = 0; i < f.length(); i++) {
                if (Pattern.matches("[0-9]", f.charAt(i) + "")) {
                    head = f.substring(0, i);
                    int stopIdx = 0;
                    for (int j = i + 1; j < f.length(); j++) {
                        if (Pattern.matches("[0-9]", f.charAt(j) + "") == false) {
                            stopIdx = j;
                            break;
                        }
                    }

                    if (stopIdx == 0) {
                        number = Integer.parseInt(f.substring(i));
                    } else {
                        number = Integer.parseInt(f.substring(i, stopIdx));
                        tail = f.substring(stopIdx);
                    }

                    list.add(new FileObject(head, number, tail, k, files[k]));
                    break;
                }
            }
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).getOrigTxt();
        }

        return answer;
    }
}
