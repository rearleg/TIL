import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

class UserSolution {
    static int[][] map;
    static int n;
    static int stamina;
    //    static Map<Integer, List<Integer>> adj;
    static boolean[][] pathVisited;
    static boolean[][] gateVisited;
    static int[] dr = { 0, 0, -1, 1 };
    static int[] dc = { 1, -1, 0, 0 };
    static Gate[] gates;
    static Map<Integer, Gate> gateMap;
    /*
     * N : 던전 지도의 크기 ( 12 ≤ N ≤ 350 ) mMaxStamina : 기사의 최대 체력(이동 가능 거리) ( 5 ≤
     * mMaxStamina ≤ 100 ) mMap : 던전의 지형 정보( N x N ) ( 0 ≤ mMap[][] ≤ 1 )
     */

    static class Gate {

        List<int[]> adj = new ArrayList<>();
        int id;
        int r, c;
        boolean alive = true;

        Gate(int id, int r, int c) {
            this.id = id;
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Gate [adj=" + adj.stream().map(Arrays::toString).collect(Collectors.joining(",")) + ", id=" + id + ", r=" + r + ", c=" + c + ", alive=" + alive + "]\n";
        }


    }

    void init(int N, int mMaxStamina, int mMap[][]) {
        n = N;
        map = mMap;
        stamina = mMaxStamina;
//        pathVisited = new boolean[n][n];
        gateVisited = new boolean[n + 1][n + 1];
        gates = new Gate[201];
        gateMap = new HashMap<>();

    }

    void addGate(int mGateID, int mRow, int mCol) {
        // map에도 추가
        Gate g = new Gate(mGateID, mRow, mCol);
        gates[mGateID] = g;
        map[mRow][mCol] = mGateID + 1000;

        // getAdj
        getAdj(g);

    }

    void removeGate(int mGateID) {
        Gate g = gates[mGateID];
        map[g.r][g.c] = 0;
        g.alive = false;
    }

    int getMinTime(int start, int goal) {
        Gate gs = gates[start];
        Gate gg = gates[goal];
        if (gs == null || gg == null || !gs.alive || !gg.alive) return -1;
        // 다익스트라를 위한 pq
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])); // 비용으로 정렬

        // dist[id] = start -> id 최소비용
        int[] dist = new int[201];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 시작점 넣기
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curId = cur[0];
            int curDist = cur[1];

            if (curDist != dist[curId]) continue;
            // 조기 종료
            if (curId == goal) return curDist;

            Gate gid = gates[curId];
            if (gid == null) continue;

            for (int[] e : gid.adj) {
                int targetId = e[0];
                int targetDist = e[1];

                Gate tg = gates[targetId];
                if(tg == null || !tg.alive) continue;
                if(gates[targetId] == null) continue;

                int nd = curDist + targetDist ; // start -> cur -> target

                if (nd < dist[targetId]) {
                    dist[targetId] = nd;
                    pq.add(new int[] {targetId, nd});
                }
            }
        }
        return -1;
    }

    void getAdj(Gate g) {
        boolean[] linked = new boolean[201];

        // 방
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> q = new ArrayDeque<>();

        visited[g.r][g.c] = true;
        q.add(new int[]{g.r, g.c, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];

            // d == stamina면 움직일 수 없음
            if (d == stamina) continue;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (!valid(nr, nc)) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == 1) continue;

                visited[nr][nc] = true;

                // 게이트라면 간선 후보
                if (map[nr][nc] >= 1000){
                    int otherId = map[nr][nc] - 1000;

                    // 자기 자신 제외 + 살아있는 게이트만
                    if (otherId != g.id && gates[otherId] != null && gates[otherId].alive && !linked[otherId]) {
                        linked[otherId] = true;

                        int cost = d + 1;

                        // 양방향 간선 추가
                        g.adj.add(new int[]{otherId, cost});
                        gates[otherId].adj.add(new int[]{g.id, cost});
                    }
                }
                q.add(new int[]{nr, nc, d + 1});
            }

        }

    }

    boolean valid(int r, int c) {
        return (0 <= r && r < n && 0 <= c && c < n);
    }

}