import java.io.*;
import java.util.*;

public class Solution {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int answer = 0;
    public static int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;


        int result = bfs(new int[]{0,0},maps , n, m);
        return result;
    }

    public static int bfs(int[] s, int[][] maps, int n, int m) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[n][m];
        dist[0][0] = 1;
        q.add(s);

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || n <= nr || m <= nc) continue;

                if (maps[nr][nc] == 1 && dist[nr][nc] == 0) {
                    dist[nr][nc] = dist[r][c] + 1;
                    
                    if (nr == n - 1 && nc == m - 1) return dist[nr][nc];

                    q.add(new int[] {nr,nc});
                }
            }
        }
        return -1;
    }
}