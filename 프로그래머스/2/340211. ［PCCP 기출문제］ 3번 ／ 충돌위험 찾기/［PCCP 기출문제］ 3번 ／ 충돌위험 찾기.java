import java.util.*;

class Solution {

    static class Robot {
        int r, c;
        int[] route;
        int targetIdx = 1;
        boolean isAlive = true;

        Robot(int r, int c, int[] route) {
            this.r = r;
            this.c = c;
            this.route = route;
        }

        void move(int[][] points) {
            int target = route[targetIdx] - 1;
            int gr = points[target][0];
            int gc = points[target][1];

            if (r != gr) {
                r += r < gr ? 1 : -1;
            } else if (c != gc) {
                c += c < gc ? 1 : -1;
            }
        }

        void updateTargetOrDie(int[][] points) {
            int target = route[targetIdx] - 1;
            int gr = points[target][0];
            int gc = points[target][1];

            if (r == gr && c == gc) {
                targetIdx++;

                if (targetIdx == route.length) {
                    isAlive = false;
                }
            }
        }
    }

    public int solution(int[][] points, int[][] routes) {
        Robot[] robots = init(points, routes);

        int ans = 0;
        ans += crashCheck(robots);

        while (hasAlive(robots)) {
            moveRobots(robots, points);
            ans += crashCheck(robots);
            updateRobots(robots, points);
        }

        return ans;
    }

    static Robot[] init(int[][] points, int[][] routes) {
        Robot[] robots = new Robot[routes.length];

        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];

            int start = route[0] - 1;
            int r = points[start][0];
            int c = points[start][1];

            robots[i] = new Robot(r, c, route);
        }

        return robots;
    }

    static void moveRobots(Robot[] robots, int[][] points) {
        for (Robot robot : robots) {
            if (!robot.isAlive) continue;
            robot.move(points);
        }
    }

    static void updateRobots(Robot[] robots, int[][] points) {
        for (Robot robot : robots) {
            if (!robot.isAlive) continue;
            robot.updateTargetOrDie(points);
        }
    }

    static boolean hasAlive(Robot[] robots) {
        for (Robot robot : robots) {
            if (robot.isAlive) return true;
        }
        return false;
    }

    static int crashCheck(Robot[] robots) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Robot robot : robots) {
            if (!robot.isAlive) continue;

            int key = robot.r * 1000 + robot.c;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int cnt = 0;
        for (int v : map.values()) {
            if (v >= 2) cnt++;
        }

        return cnt;
    }
}