import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[] indegree;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        indegree = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            indegree[b]++;
        }
        int[] ans = topo();

        for (int i = 1; i <= N; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    static int[] topo() {
        Queue<int[]> q = new ArrayDeque<>();
        int[] arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(new int[] {i, 1});
                arr[i] = 1;
            }
        }


        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int order = cur[1];

            for (int i : adj[now]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.offer(new int[]{i, order+1});
                    arr[i] = order+1;
                }
            }

        }
        return arr;
    }
}
