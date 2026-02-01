import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int[] answer;
    static int cnt = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n+1];
        answer = new int[n+1];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        for (int i = 1; i <= n; i++) graph.get(i).sort(Collections.reverseOrder());

        bfs(k, graph, visited);

        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void bfs(int s, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        visited[s] = true;
        answer[s] = cnt++;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    answer[next] = cnt++;
                }
            }
        }

    }
}