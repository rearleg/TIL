
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static final int INF = Integer.MAX_VALUE;

    static ArrayList<int[]>[] adj;    // 인접리스트
    static int[] dist;
    static int[] parent;
    static int[] record;
    static int recordSize = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        dist = new int[N+1];
        parent = new int[N+1];
        record = new int[N];

        for (int i = 0 ; i <= N; i++) adj[i] = new ArrayList<>();
        Arrays.fill(dist, INF);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[s].add(new int[]{e, w});
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dijk(s);
        int cnt = backward(e);
        System.out.println(dist[e]);
        System.out.println(cnt);
        for (int i = recordSize-1; i >= 0; i--) {
            System.out.print(record[i] + " ");
        }
    }

    static int backward(int end) {
        int cur = end;
        int cnt = 0;

        while (cur != 0) {
            record[recordSize++] = cur;
            cnt++;
            cur = parent[cur];
        }

        return cnt;
    }

    static void dijk(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        pq.offer(new int[] {start, 0});
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
                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    parent[next] = now;
                    pq.offer(new int[]{next, newCost});
                }
            }
        }


    }

}
