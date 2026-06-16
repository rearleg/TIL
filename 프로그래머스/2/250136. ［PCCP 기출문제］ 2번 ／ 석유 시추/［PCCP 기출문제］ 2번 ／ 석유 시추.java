import java.util.*;

class Solution {
    
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int rSize;
    static int cSize;
    static int ans;
    
    static int[][] grid;
    
    static int num = -1;
    
    static Map<Integer, Integer> map;
    
    public int solution(int[][] land) {
        ans = 0;
        rSize = land.length;
        cSize = land[0].length;
        
        grid = land;
        
        map = new HashMap<>();
        
        
        for (int r = 0; r < rSize; r++) {
            for (int c = 0; c < cSize; c++) {
                if(land[r][c] == 1) {
                    map.put(num, bfs(r, c));
                    num--;
                }
            }
        }
        
        for (int c = 0; c < cSize; c++) {
            Set<Integer> visited = new HashSet<>();
            int total = 0;
            
            for (int r = 0; r < rSize; r++) {
                if (grid[r][c] < 0) {
                
                    if(!visited.contains(grid[r][c])) {
                        visited.add(grid[r][c]);
                        total += map.get(grid[r][c]);
                    }
                } 
            }
            ans = Math.max(total, ans);
        }
        
        // debug
        // for (int i = 0; i < rSize; i++) {
        //     for (int j = 0; j < cSize; j++) {
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println(map);
        
        return ans;
    }
    
    static int bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        int cnt = 0;
        
        q.offer(new int[] {r, c});
        cnt++;
        grid[r][c] = num;
        
        while(!q.isEmpty()) {
            
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
        
            for (int d = 0; d < 4; d++) {

                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(!valid(nr, nc)) continue;
                if(grid[nr][nc] < 1) continue;

                q.offer(new int[] {nr, nc});
                cnt++;
                grid[nr][nc] = num;

            }
        }
        
        return cnt;
    }
    
    static boolean valid(int r, int c) {
        return 0 <= r && r < rSize && 0 <= c && c < cSize;
    }
}