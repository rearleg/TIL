
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class Main {
    static int[] parent;
    static long ans = 0;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> arr = new ArrayList<>();
        List<int[]> edges = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // 행성 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            // 번호 달아주기
            arr.add(new int[] {i, x, y, z});
        }

        // 간선 줄이기
        // x
        for (int k = 1; k <= 3; k++) {
            int idx = k;
            arr.sort((a, b) -> Integer.compare(a[idx], b[idx]));
            for (int i = 0; i < n - 1; i++) {
                int[] p1 = arr.get(i);
                int[] p2 = arr.get(i+1);
                int cost = Math.abs(p1[idx] - p2[idx]);
                edges.add(new int[]{p1[0], p2[0], cost});
            }
        }

        // edges 만들어주기


        edges.sort((a, b) -> Integer.compare(a[2], b[2]));

        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            int cost = e[2];
            if (find(a) != find(b)) {
                union(a, b);
                ans += cost;
                cnt++;
                if (cnt == n - 1) break;
            }
        }

        System.out.println(ans);

    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx != ry) {
            if (rx < ry) parent[ry] = rx;
            else parent[rx] = ry;
        }
    }

}