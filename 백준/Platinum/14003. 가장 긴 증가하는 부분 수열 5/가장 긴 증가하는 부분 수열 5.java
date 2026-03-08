import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        int[] lis = new int[n];
        int len = 0;
        int max = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int pos = lowerBound(lis, len, x);
            lis[pos] = x;

            if (len == pos) len++;
            dp[i] = pos;

            if (max < pos) {
                max = pos;
                last = i;
            }
        }
        System.out.println(len);

        // 역추적
        int[] ans = new int[n];
        int idx = len -1;
        int cur = max;
        for (int i = last; i >= 0; i--) {
            if (dp[i] == cur) {
                ans[idx] = arr[i];
                cur--;
                idx--;
            }
        }
        for (int i = 0 ; i < len; i++) System.out.print(ans[i] + " ");

    }

    static int lowerBound(int[] lis, int size, int target) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = (left + right) / 2;

            if (lis[mid] >= target) {
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        return left;
    }
}

/*
10
11 5 10 12 7 14 3 8 24 2
 */