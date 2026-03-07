import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] T = new int[n+1];
        int[] P = new int[n+1];
        int[] dp = new int[n+2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = n; i > 0; i--) {
            dp[i] = dp[i+1];
            if (i + T[i] > n + 1) continue;

            dp[i] = Math.max(dp[i], dp[i + T[i]] + P[i]);
            max = Math.max(dp[i], max);
        }
        System.out.println(max);


    }


}
