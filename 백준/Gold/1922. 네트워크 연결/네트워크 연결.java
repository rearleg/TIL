
import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<int[]> edge;

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        edge = new ArrayList<>();
        parent = new int[n+1];

        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edge.add(new int[]{s, e, w});
        }

        Collections.sort(edge, (a, b) -> a[2] - b[2]);

        int ans = 0;

        for (int[] cur : edge) {
            int a = cur[0];
            int b = cur[1];
            int cost = cur[2];
            if (union(a, b)) ans += cost;
        }

        System.out.println(ans);

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
