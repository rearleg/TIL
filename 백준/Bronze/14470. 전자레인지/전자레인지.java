
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        int ans = 0;
        if (a < 0) {
            ans += c * (a * -1);
            a = 0;
        }
        if (a == 0) ans += d;
        ans += (b - a) * e;
        System.out.println(ans);

    }
}
