import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static boolean[][] graph;
    static int[] indegree;
    static StringBuilder sb;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            sb = new StringBuilder();

            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            indegree = new int[N+1];
            graph = new boolean[N+1][N+1];
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    graph[arr[i]][arr[j]] = true;
                    indegree[arr[j]]++;
                }
            }

            int M = Integer.parseInt(br.readLine());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (graph[a][b]) {
                    graph[a][b] = false;
                    graph[b][a] = true;
                    indegree[a]++;
                    indegree[b]--;
                } else {
                    graph[a][b] = true;
                    graph[b][a] = false;
                    indegree[a]--;
                    indegree[b]++;
                }
            }
            if (!cycleCheck()) {
                System.out.println("IMPOSSIBLE");
            }
            else {
                System.out.println(sb);
            }
        }
    }

    static boolean cycleCheck() {
        Queue<Integer> q = new ArrayDeque<>();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");
            count++;

            for (int next = 1; next <= N; next++) {
                if (!graph[now][next]) continue;

                indegree[next]--;

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return count == N;
    }
}
