import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[][] w;
    static int[][] dp;
    static final int INF = 100000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        dp = new int[n][1 << n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) w[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        int result = dfs(0, 1);

        System.out.println(result);
    }

    static int dfs(int now, int mask) {
        //base case
        if (mask == (1 << n) - 1) {

            if (w[now][0] == 0) return INF;

            return w[now][0];
        }

        if (dp[now][mask] != -1) {
            return dp[now][mask];
        }

        dp[now][mask] = INF;

        for (int next = 0; next < n; next++) {

            if ((mask & (1 << next)) != 0) continue;

            if (w[now][next] == 0) continue;

            int newMask = mask | (1 << next);

            int cost = w[now][next] + dfs(next, newMask);

            dp[now][mask] = Math.min(dp[now][mask], cost);
        }
        return dp[now][mask];
    }
}
