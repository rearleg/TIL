import java.io.*;
import java.util.*;

public class Main {
    static int[][] grid;
    static int[][] dist;
    static final int INF = Integer.MAX_VALUE;
    static int[] dr = {0, 1, -1, 0};
    static int[] dc = {1, 0, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            grid = new int[n][n];
            dist = new int[n][n];

            // 배열 초기화
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)  {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }
            dijkstra(n);
            System.out.println("Problem "+T+": " + dist[n-1][n-1]);
            T++;

        }
    }

    static void dijkstra(int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        boolean[][] visited = new boolean[n][n];

        dist[0][0] = grid[0][0];
        pq.add(new int []{0, 0, dist[0][0]});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int cost = cur[2];

            if (cost > dist[r][c]) continue;
            if (r == n-1 && c == n-1) break;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (!valid(nr, nc, n)) continue;

                int weight = grid[nr][nc];
                int newCost = dist[r][c] + weight;
                if (newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    pq.add(new int[] {nr, nc, newCost});
                }

            }

        }

    }

    static boolean valid(int r, int c, int n) {
        return (0 <= r && 0 <= c && r < n && c < n);
    }
}