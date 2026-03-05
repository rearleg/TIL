import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n <= 2) System.out.println(1);
        else {
            long[] dp = new long[n+1];
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i<= n; i++) {
                dp[i] = dp[i-1]+dp[i-2];
            }
            System.out.println(dp[n]);
        }
    }
}