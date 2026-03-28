
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;

    static final int INF = Integer.MAX_VALUE;

    static int[][] map;
    static int[][] dist;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        dijk();
//        for (int i = 0 ; i < N; i++) System.out.println(Arrays.toString(dist[i]));
        System.out.println(dist[N-1][M-1]);

    }

    static void dijk() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        pq.offer(new int[]{0, 0, 0,});
        dist[0][0] = map[0][0];


        while(!pq.isEmpty()) {

            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int cost = cur[2];

            if (cost > dist[r][c]) continue;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (!valid(nr, nc)) continue;

                int weight = map[nr][nc];

                int newCost = cost + weight;
                if (newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    pq.offer(new int[] {nr, nc, newCost});
                }

            }
        }

    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
