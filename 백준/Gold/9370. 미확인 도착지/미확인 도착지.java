import java.nio.Buffer;
import java.util.*;
import java.io.*;

class Main{
    static List<List<int[]>> graph;
    static int[] destination;
    static int[] distS;
    static int[] distH;
    static int[] distG;
    static final int INF = Integer.MAX_VALUE;
    static int gh;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            gh = 0;

            // n, m, t
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            // s, g, h
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            // graph init
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                if ((u == g && v == h) || (v == g && u == h)) gh = w;

                graph.get(u).add(new int[] {v, w});
                graph.get(v).add(new int[] {u, w});

            }


            // 목적지 후보들
            destination = new int[t];
            for (int i = 0 ; i < t; i++) destination[i] = Integer.parseInt(br.readLine());

            // dist init
            distS = dijkstra(n, s);
            distH = dijkstra(n, h);
            distG = dijkstra(n, g);
//            System.out.println(Arrays.toString(distS));
//            System.out.println(Arrays.toString(distH));
//            System.out.println(Arrays.toString(distG));

            Arrays.sort(destination);

            for (int i : destination) {
                int A = distS[g] + gh + distH[i];
                int B = distS[h] + gh + distG[i];
                if (distS[i] == Math.min(A, B)) System.out.print(i + " ");
            }
            System.out.println();

        }
    }

    static int[] dijkstra(int n, int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        pq.add(new int[] {s, 0});
        dist[s] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost != dist[now]) continue;

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

        return dist;
    }
}