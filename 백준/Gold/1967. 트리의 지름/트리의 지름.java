import java.util.*;
import java.io.*;

class Main {
    static List<List<int[]>> graph;
    static int max;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(v).add(new int[] {u, w});
            graph.get(u).add(new int[] {v, w});
        }
        max = 0;
        bfs(bfs(1));

        System.out.println(max);


    }

    static int bfs(int s) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        int maxIdx = s;

        visited[s] = true;
        q.add(new int[] {s, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > max) {
                max = cost;
                maxIdx = now;
            }

            for (int[] edge : graph.get(now)) {
                int next = edge[0];
                int weight = edge[1];

                if(visited[next]) continue;

                int newCost = cost+weight;
                visited[next] = true;
                q.add(new int[]{next, newCost});
            }

        }
        return maxIdx;
    }
}