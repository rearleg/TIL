import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int l = 0, r = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while (true) {
            if (sum >= M) {
                ans = Math.min(ans, r - l);
                sum -= arr[l++];
            } else if (r == N) break;
            else sum += arr[r++];
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}

