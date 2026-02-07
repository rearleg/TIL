
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = bfs(n, k);

        System.out.println(result);
    }

    static int bfs(int n, int k ) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[100001];
        Arrays.fill(dist, -1);

        q.add(n);
        dist[n] = 0;

        while(!q.isEmpty()) {
            int c = q.poll();
            int[] next = {c-1, c+1, c*2};

            if (c == k) break;

            for (int nx : next) {
                if (nx < 0 || 100000 < nx) continue;
                if (dist[nx] != -1) continue;
                dist[nx] = dist[c] + 1;
                q.add(nx);
            }
        }
        return dist[k];
    }
}