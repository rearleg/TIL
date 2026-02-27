// 배운점 - 멀티소스다익스트라
import java.io.*;
import java.util.*;

public class Main {
    static int[][] grid;
    static int[][] dist;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int[][][] parent;
    static List<int[]> path;
    static int k;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 격자판 만들기
        int n = Integer.parseInt(br.readLine());
        grid = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) Arrays.fill(grid[i], 1);

        // dist 초기화
        dist = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) Arrays.fill(dist[i], INF);

        // parent 초기화
        parent = new int[n+1][n+1][2];

        // turn 리스트
        path = new ArrayList<>();

        // A - B 시작 및 끝점
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aRow = Integer.parseInt(st.nextToken());
        int aColumn = Integer.parseInt(st.nextToken());
        int bRow = Integer.parseInt(st.nextToken());
        int bColumn = Integer.parseInt(st.nextToken());

        // 회로를 지나가는 데에 필요한 비용 k
        k = Integer.parseInt(br.readLine());

        // 이미 배치된 회로
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int[][] locs = new int[x][2];
            for (int j = 0; j < x; j++) {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                locs[j][0] = r;
                locs[j][1] = c;
            }
            setCircuit(x, locs);    // 기존 회로 연결 함수
        }
        dijkstra(n, aRow, aColumn, bRow, bColumn);
        path.add(new int[] {bRow, bColumn});
        boolean state = bRow != parent[bRow][bColumn][0];
        // true = 상하 차이, false = 좌우 차이
        updatePath(bRow, bColumn, state);
        path.add(new int[] {aRow, aColumn});
        Collections.reverse(path);
//        for (int i = 0; i < path.size(); i++) System.out.println(Arrays.toString(path.get(i)));

        StringBuilder sb = new StringBuilder();
        sb.append(dist[bRow][bColumn]).append(" \n").append(path.size()).append(" ");
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i)[0]).append(" ");
            sb.append(path.get(i)[1]).append(" ");
        }
        System.out.println(sb.toString());

//        for (int i = 0; i <= n; i++) {
////            System.out.println(Arrays.toString(dist[i]));
//            for (int j = 0; j <= n; j++) System.out.print(Arrays.toString(parent[i][j]));
//            System.out.println();
//        }


    }

    static void updatePath(int r, int c, boolean state) {
        int nextR = parent[r][c][0];
        int nextC = parent[r][c][1];

        // 종료조건
        if (nextR == -1 || nextC == -1) return;

        // true = 상하, false = 좌우
        boolean nowState = r != nextR;

        // 방향이 같다면
        if(state == nowState) {
            updatePath(nextR, nextC, state);
        }
        // 방향이 다르다면
        else {
            path.add(new int[] {r, c});
            updatePath(nextR, nextC, nowState);
        }


    }

    static void dijkstra(int n, int r, int c, int tr, int tc) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        dist[r][c] = 1;
        pq.add(new int[] {r, c, 1});
        parent[r][c][0] = -1;
        parent[r][c][1] = -1;
//        int cnt = 1;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int nowR = cur[0];
            int nowC = cur[1];
            int cost = cur[2];
//            System.out.println("cnt = " + cnt++);

            if (cost > dist[nowR][nowC]) continue;
            if (nowR == tr && nowC == tc) return;

            for (int i = 0; i < 4; i++) {
                int nextR = nowR + dr[i];
                int nextC = nowC + dc[i];
                if (0 >= nextR || 0 >= nextC || nextR > n || nextC > n) continue;

                int weight = grid[nextR][nextC];

                int newCost = dist[nowR][nowC] + weight;
                if (newCost < dist[nextR][nextC]) {
                    dist[nextR][nextC] = newCost;
                    parent[nextR][nextC][0] = nowR;
                    parent[nextR][nextC][1] = nowC;
                    pq.add(new int[] {nextR, nextC, newCost});
                }

            }

        }

    }

    // 기존 회로 연결
    static void setCircuit(int x, int[][] locs) {
        int startR = locs[0][0];
        int startC = locs[0][1];

        for (int i = 1; i < x; i++) {
            int tgR = locs[i][0];
            int tgC = locs[i][1];

            // 상하 차이
            if (startR != tgR) {
                int r = startR;
                int c = startC;
                grid[r][c] = k;
                while (r != tgR) {
                    if (r < tgR) r++;
                    else r--;
                    grid[r][c] = k;
                }
            }
            // 좌우 차이
            else {
                int r = startR;
                int c = startC;
                grid[r][c] = k;
                while (c != tgC) {
                    if (c < tgC) c++;
                    else c--;
                    grid[r][c] = k;
                }
            }

            startR = tgR;
            startC = tgC;
        }

    }
}