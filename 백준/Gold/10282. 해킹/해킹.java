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

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            dist = new int[n+1];
            visited = new boolean[n+1];

            for (int i = 0; i <=n; i++) {
                graph.add(new ArrayList<>());
                dist[i] = INF;
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph.get(b).add(new int[] {a, s});
            }
            dijkstra(c);

            int cnt = 0, max = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != INF) {
                    cnt++;
                    max = Math.max(max, dist[i]);
                }
            }
            System.out.println(cnt + " " + max);

        }
    }

    static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > dist[now]) continue;

            for (int[] edge : graph.get(now)) {
                int next = edge[0];
                int w = edge[1];

                int newCost = cost + w;
                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    pq.add(new int[]{next, newCost});
                }
            }
        }
    }

}
