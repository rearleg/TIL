
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class Main {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] grid;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        int[] s = new int[2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) x = -1;
                grid[i][j] = x;
                if (x == 2) s = new int[] {i, j};
            }
        }

        bfs(n, m, s);

        for (int i = 0; i < n; i++) {
            String tmp = Arrays.stream(grid[i]).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(tmp);
        }
    }

    static void bfs(int n, int m, int[] s) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(s);
        grid[s[0]][s[1]] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (0 <= nr && nr < n && 0 <= nc && nc < m) {
                    if (grid[nr][nc] == -1) {
                        grid[nr][nc] = grid[r][c] + 1;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }

    }
}