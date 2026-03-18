import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 1000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][][] dp = new long[n+1][10][1 << 10];

        // 시작하는 숫자의 경우는 해당 경우를 방문처리 해줘야함
        // i = 2일 때, 1번 자리에서 2로 끝나는 수 = 2만 사용함, 고로 -> mask도 해당 비트를 방문처리 해줘야함
        for (int i = 1; i <= 9; i++) dp[1][i][1 << i] = 1;

        for (int i = 2; i <= n; i++) {

            // i번째 j로 끝나는 숫자
            for (int j = 0; j <= 9; j++) {

                //이전까지 사용한 oldMask
                for (int oldMask = 0; oldMask < (1 << 10); oldMask++) {
                    int newMask = oldMask | (1 << j);

                    if (j > 0) {
                        dp[i][j][newMask] += dp[i-1][j-1][oldMask];
                        dp[i][j][newMask] %= MOD;
                    }

                    if (j < 9) {
                        dp[i][j][newMask] += dp[i-1][j+1][oldMask];
                        dp[i][j][newMask] %= MOD;
                    }
                }

            }

        }

        int fullMask = (1 << 10) -1;

        long ans = 0;

        for (int j = 0; j <= 9; j++) {
            ans += dp[n][j][fullMask];
            ans %= MOD;
        }

        System.out.println(ans);

    }
}
