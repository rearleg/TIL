import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] indegree;
    static int[] ans;
    static List<List<Integer>> adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        ans = new int[N];
        adj = new ArrayList<>();

        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for (int j = 0; j < l-1; j++) {
                int y = Integer.parseInt(st.nextToken());

                adj.get(x).add(y);
                indegree[y]++;
                x = y;
            }

        }
        topo();
        boolean isDone = true;
        for (int i = 1; i <= N; i++) {
            if (indegree[i] != 0) {
                isDone = false;
                break;
            }
        }

        if (isDone) {
            for (int i = 0; i < N; i++) System.out.println(ans[i]);
        }
        else {
            System.out.println(0);
        }

    }
    static void topo() {
        Queue<Integer> q = new ArrayDeque<>();
        int idx = 0;

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                ans[idx++] = i;
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : adj.get(cur)) {
                indegree[nxt]--;

                if (indegree[nxt] == 0) {
                    q.add(nxt);
                    ans[idx++] = nxt;
                }
            }
        }
    }
}
