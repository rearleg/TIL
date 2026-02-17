import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] field;
    static int r = 0;
    static int c = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            // 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());


            field = new char[h][w];
            for (int i = 0; i < h; i++) {
                String s = br.readLine().trim();
                for (int j = 0; j < w; j++) {
                    field[i][j] = s.charAt(j);
                    if (field[i][j] == '<' || field[i][j] == '^' || field[i][j] == 'v' || field[i][j] == '>') {
                        r = i;
                        c = j;
                    }
                }
            }

            // 커맨드
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine().trim();

            for (char ch : s.toCharArray()) {
                playGame(h, w, n, ch);
            }

            System.out.print("#" + tc + " ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }

        }
    }

    static void playGame(int h, int w, int n, char cmd) {
        if (cmd == 'U') {
            int nr = r + dr[0];
            int nc = c + dc[0];
            field[r][c] = '^';
            if(check(nr, nc, h, w)) {
                if (field[nr][nc] == '.') {
                    field[nr][nc] = '^';
                    field[r][c] = '.';
                    r = nr;
                    c = nc;
                }

            }
        }
        if (cmd == 'D') {
            int nr = r + dr[1];
            int nc = c + dc[1];
            field[r][c] = 'v';
            if(check(nr, nc, h, w)) {
                if (field[nr][nc] == '.') {
                    field[nr][nc] = 'v';
                    field[r][c] = '.';
                    r = nr;
                    c = nc;
                }
            }
        }
        if (cmd == 'L') {
            int nr = r + dr[2];
            int nc = c + dc[2];
            field[r][c] = '<';
            if(check(nr, nc, h, w)) {
                if (field[nr][nc] == '.') {
                    field[nr][nc] = '<';
                    field[r][c] = '.';
                    r = nr;
                    c = nc;
                }
            }
        }
        if (cmd == 'R') {
            int nr = r + dr[3];
            int nc = c + dc[3];
            field[r][c] = '>';
            if(check(nr, nc, h, w)) {
                if (field[nr][nc] == '.') {
                    field[nr][nc] = '>';
                    field[r][c] = '.';
                    r = nr;
                    c = nc;
                }
            }
        }
        if (cmd == 'S') {
            shoot(h, w, field[r][c]);
        }
    }

    static void shoot(int h, int w, char dir) {
        if (dir == '^'){
            for (int i = r; i >= 0; i--) {
                if (field[i][c] == '#') break;
                if (field[i][c] == '*') {
                    field[i][c] = '.';
                    break;
                }
            }
        }
        if (dir == 'v'){
            for (int i = r; i < h; i++) {
                if (field[i][c] == '#') break;
                if (field[i][c] == '*') {
                    field[i][c] = '.';
                    break;
                }
            }
        }
        if (dir == '<'){
            for (int i = c; i >= 0; i--) {
                if (field[r][i] == '#') break;
                if (field[r][i] == '*') {
                    field[r][i] = '.';
                    break;
                }
            }
        }
        if (dir == '>'){
            for (int i = c; i < w; i++) {
                if (field[r][i] == '#') break;
                if (field[r][i] == '*') {
                    field[r][i] = '.';
                    break;
                }
            }
        }
    }

    static boolean check(int r, int c, int h, int w) {
        return 0 <= r && 0 <= c && r < h && c < w;
    }

}