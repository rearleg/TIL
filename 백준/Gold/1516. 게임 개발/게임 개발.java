import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] indegree;
    static int[] prices;
    static int[] ans;
    static List<List<Integer>> adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // 인접 리스트 준비
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        // indegree 준비
        indegree = new int[n+1];
        prices = new int[n+1];
        ans = new int[n+1];

        // 입력 받기
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            prices[i] = m;

            while (st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) break;

                adj.get(x).add(i);
                indegree[i]++;
            }
        }
        bfs();

        for (int i = 1; i <= n; i++) System.out.println(ans[i]);

    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            ans[i] = prices[i];
            if (indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            // 다음 탐색
            for (int x : adj.get(cur)) {
                ans[x] = Math.max(ans[x], ans[cur] + prices[x]);
                indegree[x]--;

                if (indegree[x] == 0) q.add(x);
            }
        }
    }
}
