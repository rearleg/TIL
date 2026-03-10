import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0 ; i < N; i++) set.add(br.readLine().trim());

        int cnt = 0;
        for (int i = 0 ; i < M; i++) {
            if (set.contains(br.readLine().trim())) cnt++;

        }
        System.out.println(cnt);
    }
}

