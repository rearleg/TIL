import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        long mod = 1_000_000_007;

        long[][][] dp = new long[101][101][101];
        dp[1][1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                for (int k = 1; k <= r; k++) {
                    dp[i][j][k] = (dp[i-1][j-1][k] + dp[i-1][j][k-1] + (dp[i-1][j][k] * (i-2))) % mod;
                }
            }
        }
        System.out.println(dp[n][l][r]);
    }
}
