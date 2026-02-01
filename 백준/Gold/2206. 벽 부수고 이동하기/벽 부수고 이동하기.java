import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int answer;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 배열 받기
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s[j] - '0';
            }
        }
        int result = bfs(grid, n, m);
        System.out.println(result);
    }

    public static int bfs(int[][] grid, int n, int m) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][][] dist = new int[n][m][2];

        int[] start = {0, 0, 0};
        q.add(start);
        dist[0][0][0] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], bomb = cur[2];

            if (r == n - 1 && c == m - 1) return dist[r][c][bomb]; // dist의 값을 리턴

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                // 범위 체크
                if (0 > nr || 0 > nc || n <= nr || m <= nc) continue;
                // 0일때 그냥 방문 (bomb이 0이건, 1일건 둘 모두의 경로에서 탐색)
                if (grid[nr][nc] == 0 && dist[nr][nc][bomb] == 0) {
                    dist[nr][nc][bomb] = dist[r][c][bomb] + 1;
                    q.add(new int[]{nr, nc, bomb});
                }

                // 폭탄을 쓰는 경로
                if (grid[nr][nc] == 1 && dist[nr][nc][1] == 0 && bomb == 0 ) {
                    // 폭탄을 썼으니 이때부터 1에 업데이트 해줘야할 것,
                    dist[nr][nc][1] = dist[r][c][bomb] + 1;
                    q.add(new int[] {nr, nc, 1});
                }
            }
        }
        return -1;
    }

}