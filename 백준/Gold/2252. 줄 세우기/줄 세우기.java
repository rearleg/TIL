import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        int[] arr = new int[n+1];

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int i = 0 ; i< m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj.get(x).add(y);
            arr[y]++;
        }

        int[] sorted = bfs(n, adj, arr);
        for (int i = 1; i <= n; i++) System.out.print(sorted[i] + " ");




    }
    static int[] bfs(int n, List<List<Integer>> adj, int[] arr) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] sorted = new int[n+1];
        int idx = 1;

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            sorted[idx++] = cur;

            for (int next : adj.get(cur)) {
                arr[next]--;
                if (arr[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return sorted;
    }
}
