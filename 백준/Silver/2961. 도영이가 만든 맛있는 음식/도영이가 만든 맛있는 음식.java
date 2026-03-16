import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] acidity = new int[n];
        int[] acerbity = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            acidity[i] = Integer.parseInt(st.nextToken());
            acerbity[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;

        for (int mask = 1; mask < (1 << n); mask++) {
            int diff = 0;
            int acidMulti = 1;
            int acerSum = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    acidMulti *= acidity[i];
                    acerSum += acerbity[i];
                }
            }
            diff = Math.abs(acidMulti-acerSum);
            if (ans > diff) ans = diff;
        }

        System.out.println(ans);
    }
}
