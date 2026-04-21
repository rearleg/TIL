import java.util.*;
import java.io.*;


public class Main {
    static ArrayList<int[]> edges;
    static int[] parent;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        edges = new ArrayList<>();

        for (int i = 0 ; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (i == j) continue;
                edges.add(new int[] {i, j, x});
            }
        }

        edges.sort((a, b) -> Integer.compare(a[2], b[2]));

        long sum = 0;
        int cnt = 0;

        for (int[] edge : edges) {
            if (cnt == N-1) break;

            int x = edge[0];
            int y = edge[1];
            if (union(x, y)) {
                sum += edge[2];
                cnt++;
            }
        }

        System.out.println(sum);


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
