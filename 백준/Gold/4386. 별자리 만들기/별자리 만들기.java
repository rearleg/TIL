import java.util.*;
import java.io.*;


public class Main {

    static ArrayList<double[]> edges;
    static int[] parent;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();
        parent = new int[N];
        for (int i = 0; i< N; i++) parent[i] = i;

        // 입력
        double[][] loc = new double[N][2];
        for (int i = 0 ; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            loc[i] = new double[] {x, y};
        }

        // 전처리 (좌표 -> 비용)
        for (int i = 0; i < N-1; i++) {
            double startX = loc[i][0];
            double startY = loc[i][1];
            for (int j = i+1; j < N; j++) {
                double endX = loc[j][0];
                double endY = loc[j][1];

                double distX = Math.abs(startX - endX);
                double distY = Math.abs(startY - endY);
                double cost = Math.sqrt((distX * distX) + (distY * distY));
                edges.add(new double[] {i, j, cost});
            }
        }

        edges.sort((a, b) -> (int) (a[2] - b[2]));

        double ans = 0.0;

        for (double[] edge : edges) {
//            System.out.println(Arrays.toString(edge));
            int x = (int) edge[0];
            int y = (int) edge[1];

            if (union(x, y)) ans += edge[2];
        }

        System.out.printf("%.2f",ans);

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
