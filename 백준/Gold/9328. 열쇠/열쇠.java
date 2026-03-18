import java.util.*;
import java.io.*;

public class Main {

    static char[][] map;
    static boolean[][] visited;
    static boolean[] keys;
    static ArrayList<int[]>[] doors;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int H;
    static int W;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H+2][W+2];
            doors = new ArrayList[26];
            
            for (int r = 0; r <= H+1; r++) {
                String line = "";
                if (r != 0 && r != H+1) line = br.readLine();
                for (int c = 0; c <= W+1; c++) {
                    if (r == 0 || c == 0 || r == H+1 || c == W+1) {
                        map[r][c] = '.';
                    }
                    else {
                        map[r][c] = line.charAt(c-1);
                    }
                }
//                System.out.println(Arrays.toString(map[r]));
            }

            keys = new boolean[26];
            String k = br.readLine();
            if (!k.equals("0")) {
                for (char ch : k.toCharArray()) {
                    keys[ch - 'a'] = true;
                }
            }

            int ans = bfs(0, 0);

            System.out.println(ans);
        }

    }
    // . < $ < A < a ( A + 32 = a)
    // a = 97
    // A = 65

    static int bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[H+2][W+2];
        q.add(new int[]{x, y});
        int result = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            // if 캐릭터 종류에 대한 처리

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (valid(nr, nc)) {
                    if (map[nr][nc] == '*') continue;

                    int nxt = map[nr][nc];

                    // $(문서) 일 때
                    if (nxt - '$' == 0) {
                        result++;
                    }

                    // 소문자(열쇠) 일때
                    else if (nxt >= 97) {
                        keys[nxt - 97] = true;
                        if (doors[nxt - 97] != null) {
                            for (int[] loc : doors[nxt - 97]) {
                                visited[loc[0]][loc[1]] = true;
                                q.add(new int[] {loc[0], loc[1]});
                            }
                        }
                    }

                    // 대문자(문) 일 때
                    else if (nxt >= 65) {
//                        System.out.println("nxt - 'A' = " + (nxt - 'A') + " nxt = " + nxt);
                        if (!keys[nxt - 'A']) {
                            if (doors[nxt - 'A'] == null) doors[nxt - 'A'] = new ArrayList<>();
                            doors[nxt - 'A'].add(new int[] {nr, nc});
                            continue;
                        }
                    }

                    q.add(new int[]{nr, nc, 0});
                    visited[nr][nc] = true;
                }
            }

        }

        return result;
    }

    static boolean valid(int r, int c) {
        return (0 <= r && 0 <= c && r < H+2 && c < W+2) && !visited[r][c];
    }
}
