
import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            parent = new int[N];
            
            for (int i = 0; i < N; i++) parent[i] = i;

            int[][] edges = new int[M][3];

            int total = 0;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                total += w;

                edges[i] = new int[]{s, e, w};
            }

            Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

            int ans = 0;

            for (int[] edge : edges) {
                int s = edge[0];
                int e = edge[1];
                int w = edge[2];

                if (union(s, e)) ans += w;
            }

            System.out.println(total - ans);
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
