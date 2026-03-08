import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 최대
        int[] dp = new int[n];
        int max = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            if (max < dp[i]) {
                max = Math.max(max, dp[i]);
                last = i;
            }
        }

        System.out.println(max);
        // 역추적
        int[] ans = new int[max];
        int idx = max - 1;
        int cur = max;
        for (int i = last; i >= 0; i--) {
            if (dp[i] == cur) {
                ans[idx] = arr[i];
                cur--;
                idx--;
            }
        }
        for (int i = 0 ; i < max; i++) {
            System.out.print(ans[i] + " ");
        }


    }
}
