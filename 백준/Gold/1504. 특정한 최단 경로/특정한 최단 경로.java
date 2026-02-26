import java.io.*;
import java.util.*;

public class Main {
    static List<List<int[]>> graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        graph = new ArrayList<>();

        // 기본 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 간선 리스트 채우기
        dist = new int[n+1];;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 입력 받아서 간선 리스트 업데이트
        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            // 양방향으로 조지기
            graph.get(x).add(new int[]{y, z});
            graph.get(y).add(new int[]{x, z});
        }


        st= new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 3개 해야함
        // 1부터 v1, v2를 구하고
        // v1부터 v2, v2부터 v1 구해야함 (근데 양방향이니까 v1 to v2, v2 to v1 같음)
        // 그래서 사실 2개만 구하면 됨
        // 1부터 v1, v2의 최소값을 구하고 v1 to v2를 구하면 됨
        // 그리고 마지막에 n까지 가야함
        dijkstra(1);
        int ans = 0;

        if (dist[v1] == INF || dist[v2] == INF || dist[n] == INF) System.out.println(-1);
        else {
            // 1 -> v1
            int oneToV1 = dist[v1];
            // 1 -> v2
            int oneToV2 = dist[v2];

            dijkstra(v1);
            int v1ToV2 = dist[v2];

            // v1 -> n
            int v1ToN = dist[n];
            dijkstra(v2);
            // v2 -> n
            int v2ToN = dist[n];

            ans = Math.min(oneToV1 + v1ToV2 + v2ToN, oneToV2 + v1ToV2 + v1ToN);
            System.out.println(ans);
        }




    }

    static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.add(new int[] {start, 0});

        while (!pq.isEmpty()) {
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
