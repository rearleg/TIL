import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i =0 ; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            int ans = 1;
            while(k > 0) {
                ans = ans * k % 10;
                k--;
            }
            System.out.println(ans);
        }
    }
}
