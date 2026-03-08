import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // dp[n][l][r] = n개의 수열을 수행했고, 왼쪽이 l, 오른쪽이 r에 있을 때 최소 누적 힘
        int[][][] dp = new int[100001][5][5];
        // 한 발을 이동할 때 드는 힘을 미리 저장하기(mp[1][2] -> 1에서 2로 이동할 때 드는 힘)
        int[][] mp = {
                {0, 2, 2, 2, 2},    // 0에서 이동하는 힘
                {2, 1, 3, 4, 3},    // ...
                {2, 3, 1, 3, 4},
                {2, 4, 3, 1, 3},
                {2, 3, 4, 3, 1}
        };

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 100001; k++)
                    dp[k][i][j] = Integer.MAX_VALUE;    // 큰 수로 초기화
            }
        }

        dp[0][0][0] = 0;
        int s = 1;

        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (dp[s - 1][i][j] == Integer.MAX_VALUE) continue;

                    // 오른발을 n으로 이동
                    dp[s][i][n] = Math.min(dp[s][i][n], dp[s - 1][i][j] + mp[j][n]);

                    // 왼발을 n으로 이동
                    dp[s][n][j] = Math.min(dp[s][n][j], dp[s - 1][i][j] + mp[i][n]);
                }
            }
            s++;
        }
        s--;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                min = Math.min(min, dp[s][i][j]);
        }
        System.out.println(min);

    }
}
