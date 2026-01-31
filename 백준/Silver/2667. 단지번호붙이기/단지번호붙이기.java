import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static List<Integer> answer = new ArrayList<>();
    static int fullCnt = 0;
    static int[][] grid;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) grid[i][j] = s[j] - '0';
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    fullCnt++;
                    int houseCnt = dfs(r, c, n);
                    answer.add(houseCnt);
                }
            }
        }
        answer.sort(null);
        System.out.println(fullCnt);
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    public static int dfs(int r, int c, int n) {
        grid[r][c] = 0;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (0 <= nr && nr < n && 0 <= nc && nc < n && grid[nr][nc] == 1) {
                cnt += dfs(nr, nc, n);
            }
        }
        return cnt;
    }
}