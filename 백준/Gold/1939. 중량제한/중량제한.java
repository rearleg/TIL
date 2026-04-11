import java.util.*;
import java.io.*;

class Main {

    static int[] dist;
    static ArrayList<int[]>[] adj;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, 0);

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[s].add(new int[] {e, c});
            adj[e].add(new int[] {s, c});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijk(start);

        System.out.println(dist[end]);

    }

    static void dijk(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        pq.offer(new int[]{start, INF});
        dist[start] = INF;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (dist[now] > cost) continue;

            for (int[] edge : adj[now]) {
                int next = edge[0];
                int weight = edge[1];

                int newCost = Math.min(cost, weight);
                if (dist[next] < newCost) {
                    dist[next] = newCost;
                    pq.offer(new int[] {next, newCost});
                }
            }
        }

    }
}
