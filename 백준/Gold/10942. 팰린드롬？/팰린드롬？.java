import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 배열 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        // dp 배열 만들기
        // dp[i][j] 정의 : i로 시작해서 j로 끝나는 배열은 팰린드롬인가?
        boolean[][] dp = new boolean[n+1][n+1];


        for (int len = 1; len <= n; len++) {    // 길이
            for (int i = 1; i + len - 1 <= n; i++) { // 시작 인덱스
                int j = i + len - 1;                // 끝 인덱스

                if (len == 1) dp[i][j] = true;
                else if (len == 2) dp[i][j] = (arr[i] == arr[j]);
                else {
                    if (arr[i] == arr[j] && dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(dp[x][y] ? 1 : 0). append("\n");
        }
        System.out.println(sb.toString());



    }
}
