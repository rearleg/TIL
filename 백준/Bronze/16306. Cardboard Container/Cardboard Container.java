import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long V = Long.parseLong(br.readLine().trim());

        long best = Long.MAX_VALUE;

        for (long a = 1; a * a * a <= V; a++) {
            if (V % a != 0) continue;
            long V1 = V / a;

            for (long b = a; b * b <= V1; b++) {
                if (V1 % b != 0) continue;
                long c = V1 / b; // 자동으로 b <= c 보장됨 (b*b <= V1)

                long area = 2L * (a * b + b * c + c * a);
                if (area < best) best = area;
            }
        }

        System.out.println(best);
    }
}