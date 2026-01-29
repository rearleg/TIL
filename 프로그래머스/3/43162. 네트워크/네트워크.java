import java.util.*;

class Solution {
        public static void bfs(int s, int n, int[][] computers, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int next = 0; next < n; next++) {
                if (computers[cur][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, n, computers, visited);
                answer++;
            }
        }

        return answer;
    }
}