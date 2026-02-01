import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 배열 받기
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++)  {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) grid[i][j] =Integer.parseInt(st.nextToken());
        }

        Queue<int[]> q = new ArrayDeque<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 1) {
                    // 방문 좌표를 q에 넣어야함
                    int[] arr = {r, c, 0};
                    q.add(arr);
                }
            }
        }

        // 사방 탐색
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        // 다 돌고 나면 bsf
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int day = cur[2];
            answer = day;

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (0 <= nr && nr < m && 0 <= nc && nc < n && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1;
                    int[] next = {nr, nc, day+1};
                    q.add(next);
                }
            }
        }

        boolean isDone = true;
        for (int i = 0; i < m; i++) {
            if (!isDone) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    isDone = false;
                    break;
                }
            }
        }
        if (isDone) System.out.println(answer);
        else System.out.println(-1);


    }

}