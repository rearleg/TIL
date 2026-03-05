import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st.nextToken());
        int max = dp[0];

        for (int i = 1 ; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i-1]+x, x);
            if (dp[i] > max) max = dp[i];

        }

        System.out.println(max);
    }
}