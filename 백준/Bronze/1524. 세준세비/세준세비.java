import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int maxS = 0, maxB = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                maxS = Math.max(maxS, Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                maxB = Math.max(maxB, Integer.parseInt(st.nextToken()));
            }
            bw.write(maxS < maxB ? "B\n" : "S\n");

        }
        bw.flush();
    }

}