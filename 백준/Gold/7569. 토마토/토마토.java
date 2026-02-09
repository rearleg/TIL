
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {-1, 1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int ans = 0;
    public static void main (String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> q = new ArrayDeque<>();
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] tomatos = new int[h][n][m];

        // 배열을 받아버리면서 q에 넣어버리기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    tomatos[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomatos[i][j][k] == 1) {
                        q.add(new int[]{i, j, k, 0});
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int ch = cur[0];
            int cr = cur[1];
            int cc = cur[2];
            int t = cur[3];
            if (ans < t) ans = t;

            // super 6방 탐색
            for (int i = 0; i < 6; i++) {
                int nh = ch + dh[i];
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (0 <= nr && 0 <= nc && 0 <= nh && nr < n && nc < m && nh < h) {
                    if (tomatos[nh][nr][nc] == 0) {
                        tomatos[nh][nr][nc] = 1;
                        q.add(new int[] {nh, nr, nc, t+1});
                    }
                }
            }
        }

        boolean check = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatos[i][j][k] == 0) {
                        check = false;
                        break;
                    }
                }
                if(!check) break;
            }
            if (!check) break;
        }

        System.out.println(check ? ans : -1);





//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.println(Arrays.toString(tomatos[i][j]));
//            }
//        }
    }
}