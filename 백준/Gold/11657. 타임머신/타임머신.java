import java.util.*;
import java.io.*;


public class Main {

    static ArrayList<int[]> edges;
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new int[] {s, e, c});
        }

        dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 1; i < N; i++) {
            if(!bellmanFord()) break;
        }

        StringBuilder sb = new StringBuilder();
        if (checkCycle()) sb.append(-1);
        else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) sb.append(-1).append('\n');
                else sb.append(dist[i]).append('\n');
            }
        }
        System.out.println(sb);


    }

    static boolean checkCycle() {
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            if (dist[from] == INF) continue;

            if (dist[to] > dist[from] + cost) {
                return true;
            }
        }
        return false;
    }

    static boolean bellmanFord() {
        boolean updated = false;

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            if (dist[from] == INF) continue;

            if (dist[to] > dist[from] + cost) {
                dist[to] = dist[from] + cost;
                updated = true;
            }
        }
        return updated;
    }
}
