import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] lst = new int[n];
        for (int i = 0; i < n; i++) {
            lst[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int now = k;
        while (now > 0) {
            for (int i = n-1; i >= 0; i--) {
                if (lst[i] <= now) {
                    now -= lst[i];
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}

