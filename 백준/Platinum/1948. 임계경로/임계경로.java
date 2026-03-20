import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int start;
    static int end;

    static List<List<int[]>> adj;
    static List<List<int[]>> revAdj;
    static int[] indegree;
    static int[] dist;
    static boolean[] visited;
    static int cnt;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // 배열초기화
        indegree = new int[n+1];
        dist = new int[n+1];
        visited = new boolean[n+1];

        adj = new ArrayList<>();
        revAdj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }

        // u -> v 간 거리 w
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new int[]{v, w});
            revAdj.get(v).add(new int[]{u, w});
            indegree[v]++;

        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        topo(start, adj, false);
        topo(end, revAdj, true);

//        System.out.println(Arrays.toString(dist));
        System.out.println(dist[end]);
        System.out.println(cnt);
    }

    static void topo(int x, List<List<int[]>> graph, boolean isRevered) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        if (isRevered) visited[x] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int[] next : graph.get(cur)) {
                int e = next[0];
                int weight = next[1];

                if (isRevered) {    // 역방향일 때
                    if (dist[cur] == dist[e] + weight) {
                        cnt++;

                        if (!visited[e]) {
                            visited[e] = true;
                            q.add(e);
                        }
                    }
                }
                else {              // 순방향일 때
                    indegree[e]--;
                    dist[e] = Math.max(dist[e], dist[cur] + weight);
                    if (indegree[e] == 0) {
                        q.add(e);
                    }
                }
            }

        }
    }
}
