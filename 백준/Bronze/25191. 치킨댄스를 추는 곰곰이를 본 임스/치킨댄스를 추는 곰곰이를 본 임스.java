import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cola = Integer.parseInt(st.nextToken());
        int bear = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while (n > 0 ) {
            if (cola > 1) {
                cnt++;
                n--;
                cola -= 2;
            } else if (bear > 0) {
                cnt++;
                n--;
                bear -= 1;
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }
}

