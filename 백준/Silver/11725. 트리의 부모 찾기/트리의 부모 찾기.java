import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<List<Integer>> graph;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        parent = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        bfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) sb.append(parent[i]).append('\n');
        System.out.print(sb);
    }

    static void bfs(int root) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(root);
        parent[root] = -1; // 루트 표시(아무 값이나)

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if (parent[next] != 0) continue; // 이미 부모가 정해졌으면 방문한 것
                parent[next] = cur;
                q.add(next);
            }
        }
    }
}