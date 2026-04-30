import java.util.Queue;
import java.util.ArrayDeque;

class Solution {

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int answer = bfs(n, m, maps);
        return answer;
    }

    public static int bfs(int n, int m, int[][] maps){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if(r == n-1 && c == m-1) return dist;

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m || maps[nr][nc] == 0) continue;

                if(!visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, dist+1});
                }
            }
        }

        return -1;
    }
}