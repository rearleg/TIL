import java.util.*;
import java.io.*;

public class Main {

    static int[] dist;
    static int[] items;
    static ArrayList<int[]>[] adj;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        items = new int[N+1];
        dist = new int[N+1];


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[s].add(new int[]{e, w});
            adj[e].add(new int[]{s, w});
        }

        int ans = 0;
        int idx = -1;

        for (int i = 1; i <= N; i++) {
            dijk(i);
//            System.out.println(Arrays.toString(dist));
//            System.out.println(Arrays.toString(items));

            int temp = 0;
            for (int j = 1; j <= N; j++) {
                if (dist[j] <= M) temp += items[j];
            }

            if (temp > ans) {
                ans = temp;
//                idx = i;
            }

        }

        System.out.println(ans);


    }

    static void dijk(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] { start, 0 });
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;


        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > dist[now]) continue;

            for (int[] edge : adj[now]) {
                int next = edge[0];
                int weight = edge[1];

                int newCost = cost + weight;
//                System.out.println(newCost);
                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    pq.offer(new int[] {next, newCost});
                }
            }
        }

    }
}
