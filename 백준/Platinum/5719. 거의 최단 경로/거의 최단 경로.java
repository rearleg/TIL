import java.util.*;
import java.io.*;

public class Main {

    static int[] dist;
    static ArrayList<Integer>[] parent;
    static ArrayList<int[]>[] adj;
    static boolean[][] removed;
    static boolean[] visited;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            removed = new boolean[N][N];
            visited = new boolean[N];

            dist = new int[N];


            adj = new ArrayList[N];
            parent = new ArrayList[N];

            for (int i = 0; i < N; i++) {
                adj[i] = new ArrayList<>();
                parent[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                adj[s].add(new int[]{e, w});
            }

            dijkstra(start);
            reverse(end);
            dijkstra(start);

            System.out.println(dist[end] == INF ? -1 : dist[end]);
        }


    }

    static void reverse(int end) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(end);
        visited[end] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int prev : parent[cur]) {
                removed[prev][cur] = true;
                if (visited[prev]) continue;

                visited[prev] = true;
                q.offer(prev);
            }
        }

    }

    static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Arrays.fill(dist, INF);

        pq.offer(new int[] {start, 0});
        dist[start] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > dist[now]) continue;

            for (int[] edge : adj[now]) {

                int next = edge[0];
                if (removed[now][next]) continue;

                int weight = edge[1];

                int newCost = cost + weight;
                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    parent[next].clear();
                    parent[next].add(now);
                    pq.offer(new int[] {next, newCost});
                }
                else if (newCost == dist[next]) {
                    parent[next].add(now);
                }
            }
        }
    }
}
