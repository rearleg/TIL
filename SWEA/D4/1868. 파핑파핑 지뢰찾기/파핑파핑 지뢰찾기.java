import java.io.*;
import java.util.*;

public class Solution {

    static int[] dr = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};
    static boolean[][] visited;
    static char[][] map;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            // map init
            visited = new boolean[N][N];
            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);

                }
            }


            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && check(i, j) == 0) cnt += bfs(i, j);
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.') cnt++;
                }
            }
            System.out.println("#" + tc + " " + cnt);

        }
    }

    static int check(int i, int j) {
        int cnt = 0;
        for (int d = 0; d < 8; d++) {
            int r = i + dr[d];
            int c = j + dc[d];
            if (isBomb(r, c)) cnt++;

        }
        return cnt;
    }

    static int bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            int cnt = check(r, c);

            // 0일 때
            if (cnt == 0) {
                map[r][c] = '0';
                for (int d = 0; d < 8; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (validClear(nr, nc)) {
                        if (visited[nr][nc]) continue;

                        q.add(new int[] {nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            // 아닐 때
            else {
                map[r][c] = 'c';
            }
        }
        return 1;
    }

    static boolean validClear(int r, int c) {
        return (0 <= r && 0 <= c && r < N && c < N && map[r][c] != '*');
    }
    static boolean isBomb(int r, int c) {
        return (0 <= r && 0 <= c && r < N && c < N && map[r][c] == '*');
    }
}