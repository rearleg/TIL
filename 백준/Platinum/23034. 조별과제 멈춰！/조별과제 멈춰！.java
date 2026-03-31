
import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;
    static int[][] costs;
    static ArrayList<int[]>[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        costs = new int[N+1][N+1];
        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            tree[i] = new ArrayList<>();
        }

        ArrayList<int[]> edges = new ArrayList<>();

        for (int i = 0; i< M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new int[] {a, b, cost});
        }

        edges.sort((a, b) -> Integer.compare(a[2], b[2]));

        // 전체 값
        int mstCost = 0;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                mstCost += edge[2];
                tree[edge[0]].add(new int[] {edge[1], edge[2]});
                tree[edge[1]].add(new int[] {edge[0], edge[2]});
            }
        }

        // 전처리
        for (int i = 1; i <= N; i++) {
            bfs(i, N);
        }

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(mstCost - costs[a][b]);


        }

    }

    static void bfs(int start, int N) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        q.offer(new int[] {start, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int cost = cur[1];

            for (int[] edge : tree[now]) {
                int nextNode = edge[0];
                int nextCost = edge[1];

                if (visited[nextNode]) continue;

                visited[nextNode] = true;
                costs[start][nextNode] = Math.max(cost, nextCost);
                q.offer(new int[] {nextNode, costs[start][nextNode]});
            }
        }

    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false;

        if (px < py) parent[py] = px;
        else parent[px] = py;
        return true;
    }
}
