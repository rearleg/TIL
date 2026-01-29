import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        s += t;
        m += s / 60;
        s = s % 60;
        h += m / 60;
        m = m % 60;

        while (h >= 24) {
            h -= 24;
        }


        System.out.println(h + " " + m + " " + s);
    }
}