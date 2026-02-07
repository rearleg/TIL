
import java.util.*;
import java.io.*;


public class Main {
    static int white = 0;
    static int blue = 0;
    static int[][] paper;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }


    static void dfs(int x, int y, int size) {

        int first = paper[x][y];
        boolean same = true;
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != first) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same) {
            if (first == 0) white++;
            else blue++;
            return;
        }

        int half = size / 2;

        dfs(x, y, half);
        dfs(x, y + half, half);
        dfs(x + half, y, half);
        dfs(x + half, y + half, half);
    }
}