import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int[] dp = new int[k+1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dp, INF);

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        for (int c : coins) {

            for (int i = c; i <= k; i++) {
//                System.out.println(i);
                if (dp[i-c] != INF) dp[i] = Math.min(dp[i], dp[i - c]+1);
            }
        }

        System.out.println(dp[k] == INF ? -1 : dp[k]);

    }
}