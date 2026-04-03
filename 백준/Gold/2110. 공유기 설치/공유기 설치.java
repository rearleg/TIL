import java.util.*;
import java.io.*;

public class Main {

    static long max;
    static int M;
    static long[] prefix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        max = 0;
        prefix = new long[N];

        int[] locs = new int[N];
        for (int i = 0; i < N; i++) {
            locs[i] = Integer.parseInt(br.readLine());
            max += locs[i];
        }
        max -= locs[0];

        Arrays.sort(locs);
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i-1] + (locs[i] - locs[i-1]);
        }
//        System.out.println(Arrays.toString(prefix));

        long ans = binary(locs, M);

        System.out.println(ans);


    }

    static long binary(int[] locs, int M) {

        long start = 0;
        long end = max;



        long ans = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            int cnt = 1;

            int left = 0;
            int right = 1;

            for (int i = 1; i < locs.length; i++) {
                long dist = prefix[right] - prefix[left];
                if (dist >= mid) {
                    cnt++;
                    left = right;
                    right++;
                }
                else {
                    right++;
                }
            }

            if (cnt >= M) {
                start = mid+1;
                ans = mid;
            }
            else {
                end = mid-1;
            }
        }
        return ans;
    }
}
