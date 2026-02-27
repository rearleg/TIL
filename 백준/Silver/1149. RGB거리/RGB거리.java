import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[3];

        StringTokenizer st = new StringTokenizer((br.readLine()));
        dp[0] = Integer.parseInt(st.nextToken());
        dp[1] = Integer.parseInt(st.nextToken());
        dp[2] = Integer.parseInt(st.nextToken());

        for (int i = 1; i< n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int nr = r + Math.min(dp[1], dp[2]);
            int ng = g + Math.min(dp[0], dp[2]);
            int nb = b + Math.min(dp[0], dp[1]);

            dp[0] = nr;
            dp[1] = ng;
            dp[2] = nb;

        }
        System.out.println(Math.min(dp[0], Math.min(dp[1], dp[2])));

    }
}