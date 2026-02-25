import java.io.*;
import java.util.*;

public class Main {
    static List<List<int[]>> graph;
    static int[] galDist;
    static int[] olDist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        graph = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        galDist = new int[n + 1];
        olDist = new int[n + 1];

        Arrays.fill(olDist, INF);

        for (int i = 0; i <= n ; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[] {b, c});
        }

        // 갈 때
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            int[] dist = new int[n + 1];
            Arrays.fill(dist, INF);

            dijkstra(i, dist);

            galDist[i] = dist[x];
//            System.out.println(Arrays.toString(galDist));
        }

        // 올 때

        dijkstra(x, olDist);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, galDist[i] + olDist[i]);
        }
        System.out.println(max);

    }

    static void dijkstra(int s, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        pq.add(new int[] {s, 0});
        dist[s] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > dist[now]) continue;

            for (int[] edge : graph.get(now)) {
                int next = edge[0];
                int weight = edge[1];

                int newCost = dist[now] + weight;
                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    pq.add(new int[] {next, newCost});
                }
            }
        }
    }
}

