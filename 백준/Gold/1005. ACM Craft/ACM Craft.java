import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int K;
    static int target;
    static int[] indegree;
    static int[] dist;
    static int[] ans;
    static List<List<Integer>> adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            indegree = new int[N+1];
            dist = new int[N+1];
            ans = new int[N+1];

            // 인접 리스트
            adj = new ArrayList<>();
            for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

            // 걸리는 시간
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) dist[i] = Integer.parseInt(st.nextToken());

            // 연결 순서
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                adj.get(x).add(y);
                indegree[y]++;
            }

            // target 값 받기
            target = Integer.parseInt(br.readLine());

            // 위상 정렬 수행
            topo();

            System.out.println(ans[target]);
        }
    }

    static void topo() {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) q.add(i);
            ans[i] = dist[i];
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : adj.get(cur)) {
                ans[nxt] = Math.max(ans[nxt], ans[cur] + dist[nxt]);
                indegree[nxt]--;

                if (indegree[nxt] == 0) {
                    q.add(nxt);
                }
            }
        }

    }
}
