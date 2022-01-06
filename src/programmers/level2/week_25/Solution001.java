package programmers.level2.week_25;

import java.util.HashSet;
import java.util.Set;

/**
 * 방문 길이 https://programmers.co.kr/learn/courses/30/lessons/49994?language=java
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        String dirs = "LRLRL";
        System.out.println(sol.solution(dirs));
    }

    public int solution(String dirs) {
        Set<Location> locationSet = new HashSet<>();
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;

        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            if (c == 'U' && endY + 1 <= 5) {
                endY++;
            } else if (c == 'D' && endY - 1 >= -5) {
                endY--;
            } else if (c == 'R' && endX + 1 <= 5) {
                endX++;
            } else if (c == 'L' && endX - 1 >= -5) {
                endX--;
            } else {
                continue;
            }

            Location newLoc = new Location(startX, startY, endX, endY);

            boolean isSameLoc = isSameLoc(locationSet, newLoc);

            if (!isSameLoc) {
                locationSet.add(newLoc);
            }

            startX = endX;
            startY = endY;
        }

        return locationSet.size();
    }

    private boolean isSameLoc(Set<Location> locationSet, Location l) {
        boolean isSameLoc = false;
        for (Location loc : locationSet) {
            if (loc.isSameLoc(l)) {
                isSameLoc = true;
            }
        }
        return isSameLoc;
    }

    class Location {
        int startX;
        int startY;
        int endX;
        int endY;

        public Location(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public boolean isSameLoc(Location loc) {
            if (this.startX == loc.startX && this.startY == loc.startY && this.endX == loc.endX && this.endY == loc.endY)
                return true;
            if (this.startX == loc.endX && this.startY == loc.endY && this.endX == loc.startX && this.endY == loc.startY)
                return true;
            return false;
        }
    }
}
