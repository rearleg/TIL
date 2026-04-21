import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            for (int j = 0; j <= i; j++) {
                ans += i + j;
            }
        }
        System.out.println(ans);
    }
}

