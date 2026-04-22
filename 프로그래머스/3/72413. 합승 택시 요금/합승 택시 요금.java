import java.io.*;
import java.util.*;

public class Solution {

    static int[][] dist;
    static final int INF = Integer.MAX_VALUE;

    static public int solution(int n, int s, int a, int b, int[][] fares) {
        
        dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for (int[] f : fares) {
            int u = f[0];
            int v = f[1];
            int w = f[2];

            dist[u][v] = w;
            dist[v][u] = w;
        }

        floyd(n);

        int ans = INF;
        for (int k = 1; k <= n; k++) {
            ans = Math.min(ans, dist[s][k] + dist[k][a] + dist[k][b]);
        }
        return ans;
    }

    static void floyd(int n) {

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] == INF || dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

//    public static void main(String[] args)throws IOException {
//        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
//        int qq = solution(6, 4, 6, 2, fares);
//    }
}
