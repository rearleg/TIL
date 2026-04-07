import java.util.*;
import java.io.*;


public class Main {

    static ArrayList<int[]> edges;
    static int[] costs;
    static int[] parent;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        costs = new int[N+1];
        for (int i = 1; i <= N; i++) {
            costs[i] = Integer.parseInt(br.readLine());
            parent[i] = i;

            if (costs[i] < min) min = costs[i];
        }

        edges = new ArrayList<>();
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int cost = costs[s] + costs[e] + l * 2;

            edges.add(new int[]{s, e, cost});
        }

        edges.sort((a, b) -> Integer.compare(a[2], b[2]));

        long sum = 0;
        int cnt = 0;

        for (int[] edge : edges) {
            if (cnt >= N-1) break;
            if (union(edge[0], edge[1])) {
                cnt++;
                sum += edge[2];
            }
        }
        sum += min;
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
