
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][m];
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < m; j++) {
                        tmp += 4;
                        arr[i][j] = tmp;
                    }
                }
                else {
                    for (int j = m-1; j >= 0; j--) {
                        tmp += 4;
                        arr[i][j] = tmp;
                    }
                }
            }

            System.out.println("#"+tc);
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.stream(arr[i]).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
            }

        }
    }
}
