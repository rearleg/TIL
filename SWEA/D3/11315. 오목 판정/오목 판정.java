
import java.io.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;


public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] s;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            arr = new char[n][n];

            for (int i = 0; i < n; i++) {
                s = br.readLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s[j];
                }
            }
            boolean isOmok = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 'o') {
                        isOmok = checkOmok(i, j, n);
                    }
                    if(isOmok) break;
                }
                if(isOmok) break;
            }

            System.out.println("#" + tc + " " + (isOmok ? "YES" : "NO"));

        }
    }

    static boolean checkOmok(int r, int c, int n) {
        int[] dr = {0, 1, 1, 1};
        int[] dc = {1, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 4; j++) {
                int nr = r + dr[i] * j;
                int nc = c + dc[i] * j;
                if (0 <= nr && nr < n && 0<= nc && nc < n) {
                    if (arr[nr][nc] != 'o') {
                        break;
                    }
                    if (j == 4) return true;
                }

            }
        }



        return false;

    }

}