import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;

    static class Edge {
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
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Edge e = new Edge(a, b, c);
            edges[i] = e;
        }
        Arrays.sort(edges, (a, b) -> a.cost - b.cost);

        // parent init
        parent = new int[V+1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        // Kruskal
        int sum = 0;
        int cnt = 0;
        
        for (int i = 0; i < E; i++) {
            Edge e = edges[i];
            
            if (union(e.from, e.to)) {
                sum += e.cost;
                cnt++;
            }
            
            if (cnt == V - 1) break;
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
        parent[py] = px;
        return true;
    }

}

