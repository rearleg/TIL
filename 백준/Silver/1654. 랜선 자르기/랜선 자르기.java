import java.util.*;
import java.io.*;

public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] lines = new long[N];
        long max = 0;
        for (int i = 0 ; i < N; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            if (max < lines[i]) max = lines[i];
        }

        long ans = binary(lines, max, N, M);
        System.out.println(ans);

    }

    static long binary(long[] lines, long max, int N, int M) {

        long left = 1;
        long right = max;

        long result = 0;

        while(left <= right) {
            long mid = (left + right) / 2;
            long tmp = 0;
            for (int i = 0; i < lines.length; i++) {
                tmp += lines[i] / mid;
            }

            if (tmp >= M) {
                result = mid;
                left = mid + 1;
            }
            else {
                right = mid-1;
            }

        }


        return result;
    }
}
