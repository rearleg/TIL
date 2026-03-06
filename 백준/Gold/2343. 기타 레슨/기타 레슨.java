import java.util.*;
import java.io.*;

class Main{
    static List<List<Integer>> adj;
    static boolean[][] ar;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int sum = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        int s = max;
        int e = sum;
        int ans = 0;

        while (s <= e) {
            int mid = (s + e) / 2;
            sum = 0;
            int cnt =0;

            for (int i = 0 ; i < n; i++) {
                if(sum + arr[i] > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += arr[i];
            }
            if (sum != 0) {
                cnt++;
            }
            if (cnt > m) {
                s = mid+1;
            }
            else {
                e = mid-1;
            }
        }
        System.out.println(s);

    }
}