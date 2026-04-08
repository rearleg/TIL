import java.util.*;
import java.io.*;


public class Main {

    static int[] dist;
    static ArrayList<int[]> edges;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            dist = new int[N+1];

            // 일반 간선
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                edges.add(new int[] {s, e, t});
                edges.add(new int[] {e, s, t});
            }

            // 음수 간선
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                t *= -1;

                edges.add(new int[] {s, e, t});
            }

            for (int i = 1; i < N; i++) {
                if (!bellmanFord()) break;
            }

            System.out.println(checkCycle() ? "YES" : "NO");
        }
    }

    static boolean checkCycle() {
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            if (dist[to] > dist[from] + cost) return true;
        }
        return false;
    }

    static boolean bellmanFord() {
        boolean updated = false;

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            if (dist[to] > dist[from] + cost) {
                dist[to] = dist[from] + cost;
                updated = true;
            }
        }

        return updated;
    }
}
