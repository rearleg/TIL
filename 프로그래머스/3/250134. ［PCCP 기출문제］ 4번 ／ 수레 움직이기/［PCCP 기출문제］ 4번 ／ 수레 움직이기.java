import java.util.*;

// 1 -> 3
// 2 -> 4
// 5 = 벽

class Solution {
    
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    
    static int ans = 1_000_000_000;
    
    static int N;
    static int M;
    
    static int rgr;
    static int rgc;
    static int bgr;
    static int bgc;
    
    public int solution(int[][] maze) {
        N = maze.length;
        M = maze[0].length;
        
        int rr = 0;
        int rc = 0;
        int br = 0;
        int bc = 0;
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (maze[r][c] == 1) {
                    rr = r;
                    rc = c;
                    continue;
                }
                
                if (maze[r][c] == 2) {
                    br = r;
                    bc = c;
                    continue;
                }
                
                if (maze[r][c] == 3) {
                    rgr = r;
                    rgc = c;
                    continue;
                }
                
                if (maze[r][c] == 4) {
                    bgr = r;
                    bgc = c;
                    continue;
                }
            }
        }
        
        boolean[][] visitedR = new boolean[N][M];
        boolean[][] visitedB = new boolean[N][M];
        visitedR[rr][rc] = true;
        visitedB[br][bc] = true;

        dfs(rr, rc, br, bc, maze, visitedR, visitedB, 0);
        
        return ans == 1_000_000_000 ? 0 : ans;
    }
    
    static void dfs(int rr, int rc, int br, int bc, int[][] maze, boolean[][] visitedR, boolean[][] visitedB, int cnt) {
        
        // 끝났는가?
        if (rr == rgr && rc == rgc && br == bgr && bc == bgc) {
            ans = Math.min(ans, cnt);
            if (ans == 0) System.out.println("!!0으로 업데이트됨 ");
        }
        
        // 하나라도 같은지 체크
        // red가 이미 들어가있다면
        if (rr == rgr && rc == rgc) {
            for (int d2 = 0; d2 < 4; d2++) {
                int nbr = br + dr[d2];
                int nbc = bc + dc[d2];

                if (!valid(nbr, nbc, maze)) continue; // 벽처리
                if (visitedB[nbr][nbc]) continue;   // 방문처리
                if (rr == nbr && rc == nbc) continue; // 겹침 처리
                visitedB[nbr][nbc] = true;

                dfs(rr, rc, nbr, nbc, maze, visitedR, visitedB, cnt+1);

                visitedB[nbr][nbc] = false;
            }
        } else if (br == bgr && bc == bgc) {
            for (int d1 = 0; d1 < 4; d1++) {
                int nrr = rr + dr[d1];
                int nrc = rc + dc[d1];

                if (!valid(nrr, nrc, maze)) continue;
                if (visitedR[nrr][nrc]) continue;
                if (nrr == br && nrc == bc) continue; // 겹침 처리
                visitedR[nrr][nrc] = true;
                
                dfs(nrr, nrc, br, bc, maze, visitedR, visitedB, cnt+1);
                
                visitedR[nrr][nrc] = false;
            }
        } else {
        //레드 먼저
            for (int d1 = 0; d1 < 4; d1++) {
                int nrr = rr + dr[d1];
                int nrc = rc + dc[d1];

                if (!valid(nrr, nrc, maze)) continue;
                if (visitedR[nrr][nrc]) continue;
                visitedR[nrr][nrc] = true;

                for (int d2 = 0; d2 < 4; d2++) {
                    int nbr = br + dr[d2];
                    int nbc = bc + dc[d2];

                    if (!valid(nbr, nbc, maze)) continue; // 벽처리
                    if (visitedB[nbr][nbc]) continue;   // 방문처리
                    if (nrr == nbr && nrc == nbc) continue; // 겹침 처리
                    if (nrr == br && nrc == bc && nbr == rr && nbc == rc) continue; // 자리바꿈 처리
                    visitedB[nbr][nbc] = true;

                    dfs(nrr, nrc, nbr, nbc, maze, visitedR, visitedB, cnt+1);
                    
                    visitedB[nbr][nbc] = false;

                }
                visitedR[nrr][nrc] = false;
            }
        }
        
        
    }
    
    static boolean valid(int r, int c, int[][] maze) {
        return 0 <= r && r < N && 0 <= c && c < M && maze[r][c] != 5;
    }
    
}




