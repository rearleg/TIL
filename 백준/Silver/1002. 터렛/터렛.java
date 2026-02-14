
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x1 - x2;
            int dy = y1 - y2;
            int dist2 = dx*dx + dy*dy;

            int sum = (r1 + r2) * (r1 + r2);
            int diff = (r1 - r2) * (r1 - r2);

            if (dist2 == 0 && r1 == r2) {
                System.out.println(-1);
            }
            else if (dist2 > sum || dist2 < diff) {
                System.out.println(0);
            }
            else if (dist2 == sum || dist2 == diff) {
                System.out.println(1);
            }
            else {
                System.out.println(2);
            }
        }
    }
}