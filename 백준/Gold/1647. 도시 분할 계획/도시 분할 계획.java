import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    static class Edge{
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Edge n = new Edge(a, b, c);
            pq.add(n);
        }

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        // Kruskal
        int sum = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {

            if (cnt == N - 2) break;
            Edge e = pq.poll();
            if (union(e.from, e.to)) {
                sum += e.cost;
                cnt++;

                
            }
        }
        System.out.println(sum);
    }

    static int find(int x) {
        if (x == parent[x]) return x;
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

