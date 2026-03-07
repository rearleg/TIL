import java.util.*;
import java.io.*;

class Main{
    static long mod = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // dp[n][h] -> 길이가 n일 때 h로 끝나는 계단 수의 종류 (경우의 수)

        int n = Integer.parseInt(br.readLine());
        // 1 ~ n까지의 가능한 수를 계산
        // 0 ~ 9까지의 숫자
        long[][] dp = new long[n+1][11];

        // 시작 수가 0으로 시작할 수 없기 때문에 1부터 1로 초기화 (0은 0으로 초기화)
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[n][i]) % mod;
        }
        System.out.println(sum);

    }
}
