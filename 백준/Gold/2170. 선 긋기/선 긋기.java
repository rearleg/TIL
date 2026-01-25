import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{x, y};
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int ans = 0;
        int start = arr[0][0];
        int end = arr[0][1];
        for (int i = 1; i < n; i++) {
            int curStart = arr[i][0];
            int curEnd = arr[i][1];
            if (curStart <= end && end < curEnd) {
                end = curEnd;
            } else if (curStart > end) {
                ans += end - start;
                start = curStart;
                end = curEnd;
            }
        }
        ans += end - start;
        System.out.println(ans);


//        for (int i = 0; i < n; i++) {
//            int[] a = arr[i];
//            System.out.println(Arrays.toString(a));
//        }

    }
}