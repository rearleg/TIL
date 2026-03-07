import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());        
        
        long s = 1, e = k;
        long ans = 0;
        
        while (s <= e) {
            long mid = (s + e) / 2;
            long cnt = 0;
            
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(n, mid / i);
            }
            if (cnt < k) s = mid + 1;
            else {
                ans = mid;
                e = mid - 1;
            }
        }
        
        System.out.println(ans);
    }
}