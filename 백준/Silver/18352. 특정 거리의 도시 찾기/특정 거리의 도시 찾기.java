
import java.util.*;
import java.io.*;

public class Main {

    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
        }

        bfs(X, adj);

        boolean check = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                check = true;
                System.out.println(i);
            }
        }

        if (!check) System.out.println(-1);

    }

    static void bfs(int start, ArrayList<Integer>[] adj) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[start] = true;
        q.offer(new int[] {start, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int weight = cur[1];

            if (weight < dist[now]) dist[now] = weight;

            for (int next : adj[now]) {
                if (visited[next]) continue;
                q.offer(new int[] {next, weight + 1});
                visited[next] = true;
            }
        }

    }
}


