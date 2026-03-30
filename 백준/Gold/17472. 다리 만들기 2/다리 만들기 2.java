import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> edges;

    static int[] parent;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1 ,0, 0};

    static int islandNum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        edges = new ArrayList<>();
        islandNum = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    setMap(i, j, true);
                }
            }
        }
//        for (int i = 0 ; i < N; i++) System.out.println(Arrays.toString(map[i]));
        visited = new boolean[N][M];

        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    setMap(i, j, false);
                }
            }
        }

        parent = new int[islandNum];
        for (int i = 1 ; i < islandNum; i++) parent[i] = i;

        edges.sort((a, b) -> Integer.compare(a[2], b[2]));

        int ans = 0;
        int used = 0;

        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                ans += edge[2];
                used++;
            }
        }

        islandNum -= 2;
        System.out.println(used == islandNum? ans : -1);


//        for (int i = 0 ; i < edges.size(); i++) System.out.println(Arrays.toString(edges.get(i)));


//
//        boolean isDone = unique > 1;
//
//
//        System.out.println(!isDone || (ans > 0) ? ans : -1);
    }

    static void setEdge(int r, int c, int cnt, int cur, int d) {

        // 영역 밖
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (!valid(nr, nc)) return;

        if (cur == map[nr][nc]) return;

        if (map[nr][nc] != 0 && cur != map[nr][nc]) {
            if (cnt <= 1) return;

            edges.add(new int[] {cur, map[nr][nc], cnt});
            return;
        }

        setEdge(r + dr[d], c + dc[d], cnt+1, cur, d);

    }

    static void setMap(int r, int c, boolean update) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];

            if(update) map[cr][cc] = islandNum;
            else {
                // dfs 간선 잇기
                for (int i = 0; i < 4; i ++) {
                    setEdge(cr, cc, 0, map[cr][cc], i);
                }
            }

            for (int i = 0 ; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (!valid(nr, nc)) continue;
                if (map[nr][nc] == 0 || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc});
            }
        }

        if (update) islandNum++;

    }
    static boolean valid(int r, int c) {
        return 0 <= r && 0 <= c && r < N && c < M;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false;
        if (px < py) parent[py] = px;
        else parent[px] = py;
        return true;
    }
}

