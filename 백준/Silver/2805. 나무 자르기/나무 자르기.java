
import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] trees = new long[n];

        st = new StringTokenizer(br.readLine());
        long max = 0;
        long min = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max) max = trees[i];
        }

        long ans = 0;

        while (min <= max) {
            long half = (min + max) / 2;
            long cut = 0;

            for (long tree : trees) {
                if (tree > half) cut += Math.max(0, tree - half);
            }

            if (cut >= m) {
                ans = half;
                min = half + 1;
            } else {
                max = half - 1;
            }

        }
        System.out.println(ans);
    }
}