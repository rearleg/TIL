import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] students;
    static boolean[] visited;
    static boolean[] finished;
    static int teamCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());

            visited = new boolean[N+1];
            finished = new boolean[N+1];
            students = new int[N+1];
            teamCnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) students[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++)
                if (!visited[i]) dfs(i);

//            System.out.println(Arrays.toString(visited));
            System.out.println(N - teamCnt);
        }
    }

    static void dfs(int cur) {
        visited[cur] = true;
        int next = students[cur];

        if (!visited[next]) dfs(next);
        else if  (!finished[next]) {
            teamCnt++;
            for (int i = next; i != cur; i = students[i]) {
                teamCnt++;
            }
        }

        finished[cur] = true;

    }
}
