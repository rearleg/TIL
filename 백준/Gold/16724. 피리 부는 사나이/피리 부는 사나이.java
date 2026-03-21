import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] finished;
    static int ans = 0;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        finished = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

//        for (int i = 0; i < N; i++) System.out.println(Arrays.toString(map[i]));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
//                    for (int q = 0; q < N; q++) System.out.println(Arrays.toString(finished[q]));
//                    System.out.println("---");
                }
            }
        }
        System.out.println(ans);

    }

    static void dfs(int r, int c) {

        visited[r][c] = true;

        char cur = map[r][c];
        int d = direction(cur);
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (!visited[nr][nc]) dfs(nr, nc);
        else if (!finished[nr][nc]) ans++;

        finished[r][c] = true;
    }


    static int direction(char cur) {
        if (cur == 'U') return 0;
        if (cur == 'D') return 1;
        if (cur == 'R') return 2;
        return 3;
    }
}
