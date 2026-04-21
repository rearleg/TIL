import java.io.*;
import java.util.*;

public class Main {
    // 최대공약수
    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    // 최소공배수
    static int lcm (int a, int b) {
        return a / gcd(a, b) * b;
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int beat = lcm(X, Y);
        int leftGap = beat / X;
        int rightGap = beat / Y;

        for (int i = 1; i <= beat; i++) {
            if (i % leftGap == 0 && i % rightGap == 0) {
                sb.append("3");
            } else if (i % leftGap == 0) {
                sb.append("1");
            } else if (i % rightGap == 0) {
                sb.append("2");
            }
        }
        System.out.println(sb.toString());
    }
}