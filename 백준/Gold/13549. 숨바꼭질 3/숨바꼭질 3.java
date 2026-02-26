import java.io.*;
import java.util.*;

public class Main {
    static List<List<int[]>> graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;
    static int cnt;
    static boolean[] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int ans = dijkstra(n, m);

        System.out.println(ans);
    }

    static int dijkstra(int n, int m) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        final int MAX = 100001;
        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[MAX];
        Arrays.fill(dist, INF);

        pq.add(new int[] {n, 0});
        dist[n] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > dist[now]) continue;
            if (now == m) return cost;

            // 순간이동 시 = 좌표 * 2, 비용 + 0
            if (now * 2 < MAX && cost < dist[now * 2]) {
                dist[now * 2] = cost;
                pq.add(new int[] {now * 2, cost});
            }
            // 뒤로 이동 시 = 좌표 - 1, 비용 + 1;

            if (now - 1 >= 0 && cost < dist[now - 1]) {
                dist[now - 1] = cost + 1;
                pq.add(new int[] {now - 1, cost + 1});
            }
            // 앞으로 이동 시 = 좌표 + 1, 비용 +1;
            if (now + 1 < MAX && cost < dist[now + 1]) {
                dist[now + 1] = cost + 1;
                pq.add(new int[] {now + 1, cost + 1});
            }

        }
        return -1;

    }
}