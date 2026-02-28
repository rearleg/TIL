import java.util.*;
import java.io.*;

class Main {
    static List<List<int[]>> graph;
    static int N;
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) break;

                int w = Integer.parseInt(st.nextToken());
                graph.get(u).add(new int[] {v, w});
            }
        }

        bfs(bfs(1));

        System.out.println(max);

    }

    static int bfs(int s) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        max = 0;
        int ans = 0;

        visited[s] = true;
        q.add(new int[] {s, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > max) {
                max = cost;
                ans = now;
            }

            for (int[] edge : graph.get(now)) {
                int next = edge[0];
                int weight = edge[1];

                if (visited[next]) continue;

                int newCost = weight + cost;
                visited[next] = true;
                q.add(new int[] {next, newCost});
            }

        }
        
        return ans;
    }
}