import java.io.*;
import java.util.*;

public class Main {
    static long A, B, C;

    static long modPow(long a, long b) {
        if (b == 0) return 1 % C;
        if (b == 1) return a % C;

        long half = modPow(a, b / 2);
        long res = (half * half) % C;

        if (b % 2 == 1) res = (res * (a % C)) % C;
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(modPow(A, B));
    }
}